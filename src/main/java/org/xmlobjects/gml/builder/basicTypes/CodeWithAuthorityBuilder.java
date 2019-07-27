package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.CodeWithAuthority;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class CodeWithAuthorityBuilder implements ObjectBuilder<CodeWithAuthority>, ObjectSerializer<CodeWithAuthority> {

    @Override
    public CodeWithAuthority createObject(QName name) {
        return new CodeWithAuthority();
    }

    @Override
    public void initializeObject(CodeWithAuthority object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }

    @Override
    public void initializeElement(Element element, CodeWithAuthority object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(object.getValue());
        element.addAttribute("codeSpace", object.getCodeSpace());
    }
}
