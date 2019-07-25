package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.basicTypes.Sign;
import org.xmlobjects.gml.model.geometry.primitives.OrientableCurve;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "OrientableCurve", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "OrientableCurve", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class OrientableCurveBuilder extends AbstractCurveBuilder<OrientableCurve> {

    @Override
    public OrientableCurve createObject(QName name) {
        return new OrientableCurve();
    }

    @Override
    public void initializeObject(OrientableCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("orientation").ifPresent(v -> object.setOrientation(Sign.fromValue(v)));
    }

    @Override
    public void buildChildObject(OrientableCurve object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

        if ("baseCurve".equals(name.getLocalPart()))
            object.setBaseCurve(reader.getObjectUsingBuilder(CurvePropertyBuilder.class));
    }

    @Override
    public Element createElement(OrientableCurve object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "OrientableCurve");
    }
}
