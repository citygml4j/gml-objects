package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.basictypes.StringOrNilReason;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class StringOrNilReasonAdapter implements ObjectBuilder<StringOrNilReason>, ObjectSerializer<StringOrNilReason> {

    @Override
    public StringOrNilReason createObject(QName name) {
        return new StringOrNilReason();
    }

    @Override
    public void initializeObject(StringOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        TextContent content = reader.getTextContent();
        NilReason nilReason = new NilReason(content.get());
        if (nilReason.getValue() != null)
            object.setNilReason(nilReason);
        else
            object.setString(content.get());
    }

    @Override
    public void initializeElement(Element element, StringOrNilReason object, Namespaces namespaces, XMLWriter writer) {
        if (object.isSetValue())
            element.addTextContent(object.getValue());
        else if (object.isSetNilReason())
            element.addTextContent(object.getNilReason().getValue());
    }
}