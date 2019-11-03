package org.xmlobjects.gml.adapter.geometry.grids;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.geometry.grids.Grid;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Grid", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Grid", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class GridAdapter extends AbstractGridAdapter<Grid> {

    @Override
    public Grid createObject(QName name) throws ObjectBuildException {
        return new Grid();
    }

    @Override
    public Element createElement(Grid object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "Grid");
    }
}
