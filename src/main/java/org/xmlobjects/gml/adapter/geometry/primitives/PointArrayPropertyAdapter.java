package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.AbstractGeometryArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.PointArrayProperty;

import javax.xml.namespace.QName;

public class PointArrayPropertyAdapter extends AbstractGeometryArrayPropertyAdapter<PointArrayProperty> {

    @Override
    public PointArrayProperty createObject(QName name) throws ObjectBuildException {
        return new PointArrayProperty();
    }
}
