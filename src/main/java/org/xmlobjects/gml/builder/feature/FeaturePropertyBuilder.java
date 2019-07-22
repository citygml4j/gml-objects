package org.xmlobjects.gml.builder.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.base.AbstractPropertyBuilder;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.feature.FeatureProperty;
import org.xmlobjects.stream.BuildResult;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class FeaturePropertyBuilder<T extends FeatureProperty> extends AbstractPropertyBuilder<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) {
        return (T) new FeatureProperty<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuildResult<AbstractFeature> result = reader.getObject(object.getTargetType());
        if (result.isSetObject())
            object.setObject(result.getObject());
        else if (result.isSetDOMElement())
            object.setGenericElement(GenericElement.of(result.getDOMElement()));
    }
}
