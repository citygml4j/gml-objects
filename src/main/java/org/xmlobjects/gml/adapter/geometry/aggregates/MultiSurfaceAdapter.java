package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.geometry.primitives.SurfaceArrayPropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SurfacePropertyAdapter;
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
        @XMLElement(name = "MultiSurface", namespaceURI = GMLConstants.GML_3_1_NAMESPACE),
        @XMLElement(name = "MultiPolygon", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class MultiSurfaceAdapter extends AbstractGeometricAggregateAdapter<MultiSurface> {

    @Override
    public MultiSurface createObject(QName name) {
        return new MultiSurface();
    }

    @Override
    public void buildChildObject(MultiSurface object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "surfaceMember":
                case "polygonMember":
                    object.getSurfaceMember().add(reader.getObjectUsingBuilder(SurfacePropertyAdapter.class));
                    break;
                case "surfaceMembers":
                    object.setSurfaceMembers(reader.getObjectUsingBuilder(SurfaceArrayPropertyAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(MultiSurface object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "MultiSurface");
    }

    @Override
    public void writeChildElements(MultiSurface object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        for (SurfaceProperty property : object.getSurfaceMember())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "surfaceMember"), property, SurfacePropertyAdapter.class, namespaces);

        if (object.getSurfaceMembers() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "surfaceMembers"), object.getSurfaceMembers(), SurfaceArrayPropertyAdapter.class, namespaces);
    }
}
