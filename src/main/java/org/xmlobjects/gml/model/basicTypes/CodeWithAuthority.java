package org.xmlobjects.gml.model.basicTypes;

public class CodeWithAuthority extends Code {

    public CodeWithAuthority() {
    }

    public CodeWithAuthority(String value) {
        super(value);
    }

    public CodeWithAuthority(String value, String codeSpace) {
        this(value);
        setCodeSpace(codeSpace);
    }
}