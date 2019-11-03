package org.xmlobjects.gml.adapter.deprecated;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.basictypes.NilReasonAdapter;
import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.deprecated.LocationProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class LocationPropertyAdapter extends AbstractGeometryPropertyAdapter<LocationProperty> {

    @Override
    public LocationProperty createObject(QName name) throws ObjectBuildException {
        return new LocationProperty();
    }

    @Override
    public void buildChildObject(LocationProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "LocationKeyWord":
                    object.setLocationKeyWord(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "LocationString":
                    object.setLocationString(reader.getObjectUsingBuilder(StringOrRefAdapter.class));
                    break;
                case "Null":
                    object.setNull(reader.getObjectUsingBuilder(NilReasonAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(LocationProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetObject())
            super.writeChildElements(object, namespaces, writer);
        else if (object.isSetLocationKeyWord())
            writer.writeElementUsingSerializer(Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "LocationKeyWord"), object.getLocationKeyWord(), CodeAdapter.class, namespaces);
        else if (object.isSetLocationString())
            writer.writeElementUsingSerializer(Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "LocationString"), object.getLocationString(), StringOrRefAdapter.class, namespaces);
        else if (object.isSetNull())
            writer.writeElementUsingSerializer(Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Null"), object.getNull(), NilReasonAdapter.class, namespaces);
    }
}
