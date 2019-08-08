package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.IntegerOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.CountList;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CountList", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "CountList", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class CountListAdapter implements ObjectBuilder<CountList>, ObjectSerializer<CountList> {

    @Override
    public CountList createObject(QName name) {
        return new CountList();
    }

    @Override
    public void initializeObject(CountList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(IntegerOrNilReasonListAdapter.class).initializeObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CountList object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CountList");
    }

    @Override
    public void initializeElement(Element element, CountList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(IntegerOrNilReasonListAdapter.class).initializeElement(element, object, namespaces, writer);
    }
}
