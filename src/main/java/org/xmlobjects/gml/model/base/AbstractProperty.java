package org.xmlobjects.gml.model.base;

import org.xmlobjects.model.Child;

public abstract class AbstractProperty<T extends Child> extends AbstractInlineOrByReferenceProperty<T> implements OwnershipAttributes {
    private Boolean owns;

    public AbstractProperty() {
    }

    public AbstractProperty(T object) {
        super(object);
    }

    public AbstractProperty(String href) {
        super(href);
    }

    @Override
    public Boolean getOwns() {
        return owns;
    }

    @Override
    public void setOwns(Boolean owns) {
        this.owns = owns;
    }
}
