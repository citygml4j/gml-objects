package org.xmlobjects.gml.model.basicTypes;

public class DoubleOrNilReason extends PrimitiveOrNilReason<Double> {

    public DoubleOrNilReason() {
    }

    public DoubleOrNilReason(Double value) {
        super(value);
    }

    public DoubleOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }

    public DoubleOrNilReason(String anyURI) {
        super(anyURI);
    }

    public void setDouble(Double value) {
        setPrimitive(value);
    }
}