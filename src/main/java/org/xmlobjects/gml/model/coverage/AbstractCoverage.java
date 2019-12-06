package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public abstract class AbstractCoverage<T extends AbstractDomainSet<?>> extends AbstractFeature {
    private T domainSet;
    private RangeSet rangeSet;

    public AbstractCoverage() {
    }

    public AbstractCoverage(T domainSet, RangeSet rangeSet) {
        setDomainSet(domainSet);
        setRangeSet(rangeSet);
    }

    public abstract void accept(ObjectVisitor visitor);

    public T getDomainSet() {
        return domainSet;
    }

    public void setDomainSet(T domainSet) {
        this.domainSet = asChild(domainSet);
    }

    public RangeSet getRangeSet() {
        return rangeSet;
    }

    public void setRangeSet(RangeSet rangeSet) {
        this.rangeSet = asChild(rangeSet);
    }
}
