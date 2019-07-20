package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.geometry.primitives.SolidArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.SolidPropertyBuilder;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolid;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MultiSolid", namespaceURI = Constants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "MultiSolid", namespaceURI = Constants.GML_3_1_NAMESPACE_URI)
})
public class MultiSolidBuilder extends AbstractGeometricAggregateBuilder<MultiSolid> {

    @Override
    public MultiSolid createObject(QName name) {
        return new MultiSolid();
    }

    @Override
    public void buildNestedObject(MultiSolid object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "solidMember":
                object.getSolidMember().add(reader.getObjectUsingBuilder(SolidPropertyBuilder.class));
                break;
            case "solidMembers":
                object.setSolidMembers(reader.getObjectUsingBuilder(SolidArrayPropertyBuilder.class));
                break;
        }
    }
}
