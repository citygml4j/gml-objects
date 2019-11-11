package org.xmlobjects.gml.model.common;

import org.w3c.dom.Element;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.Copyable;

import java.util.Objects;

public class GenericElement extends GMLObject {
    private Element content;

    private GenericElement() {
    }

    private GenericElement(Element content) {
        this.content = Objects.requireNonNull(content, "Content must not be null.");
    }

    public static GenericElement of(Element element) {
        return new GenericElement(element);
    }

    public Element getContent() {
        return content;
    }

    public String getLocalName() {
        return content.getLocalName();
    }

    public String getNamespaceURI() {
        return content.getNamespaceURI();
    }

    @Override
    public Copyable deepCopy(CopyBuilder builder) {
        return super.deepCopy(builder.withClone(content, () -> content.cloneNode(true)));
    }
}
