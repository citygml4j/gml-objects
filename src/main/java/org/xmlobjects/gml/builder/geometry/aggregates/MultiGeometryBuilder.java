package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.geometry.GeometryArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiGeometry;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MultiGeometry", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "MultiGeometry", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class MultiGeometryBuilder extends AbstractGeometricAggregateBuilder<MultiGeometry> {

    @Override
    public MultiGeometry createObject(QName name) {
        return new MultiGeometry();
    }

    @Override
    public void buildChildObject(MultiGeometry object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "geometryMember":
                object.getGeometryMember().add(reader.getObjectUsingBuilder(new GeometryPropertyBuilder<>()));
                break;
            case "geometryMembers":
                object.setGeometryMembers(reader.getObjectUsingBuilder((new GeometryArrayPropertyBuilder<>())));
                break;
        }
    }

    @Override
    public Element createElement(MultiGeometry object, Namespaces namespaces) {
        return (namespaces.contains(GMLConstants.GML_3_1_NAMESPACE_URI)) ?
                Element.of(GMLConstants.GML_3_1_NAMESPACE_URI, "MultiGeometry") :
                Element.of(GMLConstants.GML_3_2_NAMESPACE_URI, "MultiGeometry");
    }
}
