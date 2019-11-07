package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.temporal.TimeInstant;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "TimeInstant", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "TimeInstant", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class TimeInstantAdapter extends AbstractTimeGeometricPrimitiveAdapter<TimeInstant> {

    @Override
    public TimeInstant createObject(QName name) throws ObjectBuildException {
        return new TimeInstant();
    }

    @Override
    public void buildChildObject(TimeInstant object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            if ("timePosition".equals(name.getLocalPart()))
                object.setTimePosition(reader.getObjectUsingBuilder(TimePositionAdapter.class));
            else
                super.buildChildObject(object, name, attributes, reader);
        }
    }

    @Override
    public Element createElement(TimeInstant object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "TimeInstant");
    }

    @Override
    public void writeChildElements(TimeInstant object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getTimePosition() != null)
            writer.writeElementUsingSerializer(Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "timePosition"), object.getTimePosition(), TimePositionAdapter.class, namespaces);
    }
}