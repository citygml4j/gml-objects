package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.measures.Length;

import javax.xml.namespace.QName;

public class LengthAdapter extends MeasureAdapter<Length> {

    @Override
    public Length createObject(QName name) {
        return new Length();
    }
}