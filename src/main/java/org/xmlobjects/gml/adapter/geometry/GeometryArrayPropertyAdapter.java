package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.base.AbstractArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class GeometryArrayPropertyAdapter<T extends GeometryArrayProperty> extends AbstractArrayPropertyAdapter<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) throws ObjectBuildException {
        return (T) new GeometryArrayProperty<>();
    }

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        GMLBuilderHelper.buildOwnershipAttributes(object, attributes);
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        GMLSerializerHelper.serializeOwnershipAttributes(element, object, namespaces);
    }
}
