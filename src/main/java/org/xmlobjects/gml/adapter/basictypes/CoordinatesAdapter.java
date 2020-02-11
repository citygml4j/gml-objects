/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2020 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.Coordinates;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class CoordinatesAdapter implements ObjectBuilder<Coordinates>, ObjectSerializer<Coordinates> {

    @Override
    public Coordinates createObject(QName name) throws ObjectBuildException {
        return new Coordinates();
    }

    @Override
    public void initializeObject(Coordinates object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        attributes.getValue("decimal").ifPresent(object::setDecimal);
        attributes.getValue("cs").ifPresent(object::setCoordinateSeparator);
        attributes.getValue("ts").ifPresent(object::setTupleSeparator);
    }

    @Override
    public void initializeElement(Element element, Coordinates object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addTextContent(object.getValue());

        if (!object.getDecimal().equals(Coordinates.DEFAULT_DECIMAL))
            element.addAttribute("decimal", object.getDecimal());

        if (!object.getCoordinateSeparator().equals(Coordinates.DEFAULT_COORDINATE_SEPARATOR))
            element.addAttribute("cs", object.getCoordinateSeparator());

        if (!object.getTupleSeparator().equals(Coordinates.DEFAULT_TUPLE_SEPARATOR))
            element.addAttribute("ts", object.getTupleSeparator());
    }
}
