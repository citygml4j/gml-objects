package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.AbstractInlineGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.RingProperty;

import javax.xml.namespace.QName;

public class RingPropertyAdapter extends AbstractInlineGeometryPropertyAdapter<RingProperty> {

    @Override
    public RingProperty createObject(QName name) throws ObjectBuildException {
        return new RingProperty();
    }
}
