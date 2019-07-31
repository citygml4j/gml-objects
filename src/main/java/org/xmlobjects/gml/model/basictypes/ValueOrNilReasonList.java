package org.xmlobjects.gml.model.basictypes;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class ValueOrNilReasonList<T extends ValueOrNilReason> extends GMLObject {
    private List<T> value;

    ValueOrNilReasonList() {
    }

    ValueOrNilReasonList(List<T> value) {
        setValue(value);
    }

    public List<T> getValue() {
        if (value == null)
            value = new ChildList<>(this);

        return value;
    }

    public void setValue(List<T> value) {
        this.value = asChild(value);
    }
}