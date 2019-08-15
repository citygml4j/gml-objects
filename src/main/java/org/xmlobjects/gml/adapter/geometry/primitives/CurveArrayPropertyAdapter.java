package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.CurveArrayProperty;

import javax.xml.namespace.QName;

public class CurveArrayPropertyAdapter extends AbstractGeometryArrayPropertyAdapter<CurveArrayProperty> {

    @Override
    public CurveArrayProperty createObject(QName name) {
        return new CurveArrayProperty();
    }
}
