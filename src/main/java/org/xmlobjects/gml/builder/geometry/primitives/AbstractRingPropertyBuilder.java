package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.geometry.primitives.AbstractRing;
import org.xmlobjects.gml.model.geometry.primitives.AbstractRingProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class AbstractRingPropertyBuilder implements ObjectBuilder<AbstractRingProperty>, ObjectSerializer<AbstractRingProperty> {

    @Override
    public AbstractRingProperty createObject(QName name) {
        return new AbstractRingProperty();
    }

    @Override
    public void buildChildObject(AbstractRingProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getObject(AbstractRing.class).ifObject(object::setObject);
    }

    @Override
    public void writeChildElements(AbstractRingProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getObject() != null)
            writer.writeObject(object.getObject(), namespaces);
    }
}
