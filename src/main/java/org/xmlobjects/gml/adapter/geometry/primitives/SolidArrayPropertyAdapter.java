package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SolidArrayProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class SolidArrayPropertyAdapter extends GeometryArrayPropertyAdapter<SolidArrayProperty> {

    @Override
    public SolidArrayProperty createObject(QName name, Properties properties) {
        return new SolidArrayProperty();
    }
}
