package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.NameOrNilReason;
import org.xmlobjects.gml.model.basictypes.NameOrNilReasonList;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.basictypes.NilReasonEnumeration;
import org.xmlobjects.gml.util.GMLPatterns;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.XMLPatterns;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;
import java.util.Objects;
import java.util.stream.Collectors;

public class NameOrNilReasonListAdapter implements ObjectBuilder<NameOrNilReasonList>, ObjectSerializer<NameOrNilReasonList> {

    @Override
    public NameOrNilReasonList createObject(QName name) throws ObjectBuildException {
        return new NameOrNilReasonList();
    }

    @Override
    public void initializeObject(NameOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        for (String item : content.getAsList()) {
            if (NilReasonEnumeration.fromValue(item) != null
                    || GMLPatterns.OTHER_VALUE.matcher(item).matches()
                    || !XMLPatterns.NAME.matcher(item).matches())
                object.getValue().add(new NameOrNilReason(new NilReason(item)));
            else
                object.getValue().add(new NameOrNilReason(item));
        }
    }

    @Override
    public void initializeElement(Element element, NameOrNilReasonList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addTextContent(TextContent.ofList(object.getValue().stream()
                .filter(Objects::nonNull)
                .map(v -> {
                    if (v.isSetValue())
                        return v.getValue();
                    else if (v.isSetNilReason())
                        return v.getNilReason().getValue();
                    else
                        return null;
                }).collect(Collectors.toList())));
    }
}
