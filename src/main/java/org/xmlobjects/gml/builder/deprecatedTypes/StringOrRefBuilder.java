package org.xmlobjects.gml.builder.deprecatedTypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.deprecatedTypes.StringOrRef;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class StringOrRefBuilder implements ObjectBuilder<StringOrRef>, ObjectSerializer<StringOrRef> {

    @Override
    public StringOrRef createObject(QName name) {
        return new StringOrRef();
    }

    @Override
    public void initializeObject(StringOrRef object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        BuilderHelper.buildAssociationAttributes(object, attributes);
    }

    @Override
    public void initializeElement(Element element, StringOrRef object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(object.getValue());
        SerializerHelper.serializeAssociationAttributes(element, object, namespaces);
    }
}
