package org.xmlobjects.gml.model;

import org.xmlobjects.model.Child;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class GMLObject implements Child {
    private Child parent;

    protected final <T extends Child> T asChild(T child) {
        if (child != null)
            child.setParent(this);

        return child;
    }

    protected final <T extends Child> List<T> asChild(List<T> child) {
        if (child instanceof ChildList) {
            ((ChildList<T>) child).setParent(this);
            return child;
        } else
            return child != null ? new ChildList<>(child, this) : null;
    }

    @Override
    public final Child getParent() {
        return parent;
    }

    @Override
    public final void setParent(Child parent) {
        this.parent = parent;
    }
}
