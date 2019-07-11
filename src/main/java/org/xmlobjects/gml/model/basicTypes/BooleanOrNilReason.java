package org.xmlobjects.gml.model.basicTypes;

public class BooleanOrNilReason extends ValueOrNilReason<Boolean> {

    public BooleanOrNilReason() {
    }

    public BooleanOrNilReason(Boolean value) {
        super(value);
    }

    public BooleanOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }

    public BooleanOrNilReason(String anyURI) {
        super(anyURI);
    }

    public void setBoolean(Boolean value) {
        setValue(value);
    }
}
