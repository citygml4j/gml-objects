package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureAdapter;
import org.xmlobjects.gml.model.coverage.MultiCurveCoverage;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MultiCurveCoverage", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "MultiCurveCoverage", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class MultiCurveCoverageAdapter extends AbstractFeatureAdapter<MultiCurveCoverage> {

    @Override
    public MultiCurveCoverage createObject(QName name) {
        return new MultiCurveCoverage();
    }

    @Override
    public void buildChildObject(MultiCurveCoverage object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLBaseNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "domainSet":
                case "multiCurveDomain":
                    object.setDomainSet(reader.getObjectUsingBuilder(MultiCurveDomainAdapter.class));
                    break;
                case "rangeSet":
                    object.setRangeSet(reader.getObjectUsingBuilder(RangeSetAdapter.class));
                    break;
                case "coverageFunction":
                    object.setCoverageFunction(reader.getObjectUsingBuilder(CoverageFunctionAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public Element createElement(MultiCurveCoverage object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "MultiCurveCoverage");
    }

    @Override
    public void writeChildElements(MultiCurveCoverage object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        if (object.getDomainSet() != null) {
            String localName = GMLObjects.GML_3_2_NAMESPACE.equals(baseNamespace) ? "domainSet" : "multiCurveDomain";
            writer.writeElementUsingSerializer(Element.of(baseNamespace, localName), object.getDomainSet(), MultiCurveDomainAdapter.class, namespaces);
        }

        if (object.getRangeSet() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "rangeSet"), object.getRangeSet(), RangeSetAdapter.class, namespaces);

        if (object.getCoverageFunction() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "coverageFunction"), object.getCoverageFunction(), CoverageFunctionAdapter.class, namespaces);
    }
}
