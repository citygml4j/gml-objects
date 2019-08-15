package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.gml.model.basictypes.Measure;

import javax.xml.namespace.QName;

public class MeasureAdapter extends AbstractMeasureAdapter<Measure> {

    @Override
    public Measure createObject(QName name) {
        return new Measure();
    }
}
