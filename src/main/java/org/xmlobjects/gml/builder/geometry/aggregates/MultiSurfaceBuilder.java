package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.geometry.primitives.SurfaceArrayPropertyBuilder;
import org.xmlobjects.gml.builder.geometry.primitives.SurfacePropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
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
        @XMLElement(name = "MultiSurface", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "MultiSurface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class MultiSurfaceBuilder extends AbstractGeometricAggregateBuilder<MultiSurface> {

    @Override
    public MultiSurface createObject(QName name) {
        return new MultiSurface();
    }

    @Override
    public void buildChildObject(MultiSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "surfaceMember":
                object.getSurfaceMember().add(reader.getObjectUsingBuilder(SurfacePropertyBuilder.class));
                break;
            case "surfaceMembers":
                object.setSurfaceMembers(reader.getObjectUsingBuilder(SurfaceArrayPropertyBuilder.class));
                break;
        }
    }

    @Override
    public Element createElement(MultiSurface object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "MultiSurface");
    }

    @Override
    public void writeChildElements(MultiSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (SurfaceProperty property : object.getSurfaceMember())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "surfaceMember"), property, SurfacePropertyBuilder.class, namespaces);

        if (object.getSurfaceMembers() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "surfaceMembers"), object.getSurfaceMembers(), SurfaceArrayPropertyBuilder.class, namespaces);
    }
}
