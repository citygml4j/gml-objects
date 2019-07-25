package org.xmlobjects.gml.builder.base;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class ReferenceBuilder implements ObjectBuilder<Reference> {

    @Override
    public Reference createObject(QName name) {
        return new Reference();
    }

    @Override
    public void initializeObject(Reference object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuilderHelper.buildAssociationAttributes(object, attributes);
        BuilderHelper.buildOwnershipAttributes(object, attributes);
    }
}
