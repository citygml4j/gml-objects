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

package org.xmlobjects.gml.model.geometry.complexes;

import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class GeometricComplexProperty extends GeometryProperty<AbstractGeometry> {

    public GeometricComplexProperty() {
    }

    public GeometricComplexProperty(AbstractGeometry object) {
        setObject(object);
    }

    public GeometricComplexProperty(String href) {
        super(href);
    }

    @Override
    public void setObject(AbstractGeometry object) {
        if (object instanceof GeometricComplex
                || object instanceof CompositeCurve
                || object instanceof CompositeSurface
                || object instanceof CompositeSolid)
            super.setObject(object);
    }

    public GeometricComplex getGeometricComplex() {
        return isSetGeometricComplex() ? (GeometricComplex) getObject() : null;
    }

    public boolean isSetGeometricComplex() {
        return getObject() instanceof GeometricComplex;
    }

    public void setGeometricComplex(GeometricComplex geometricComplex) {
        super.setObject(geometricComplex);
    }

    public CompositeCurve getCompositeCurve() {
        return isSetCompositeCurve() ? (CompositeCurve) getObject() : null;
    }

    public boolean isSetCompositeCurve() {
        return getObject() instanceof CompositeCurve;
    }

    public void setCompositeCurve(CompositeCurve compositeCurve) {
        super.setObject(compositeCurve);
    }

    public CompositeSurface getCompositeSurface() {
        return isSetCompositeSurface() ? (CompositeSurface) getObject() : null;
    }

    public boolean isSetCompositeSurface() {
        return getObject() instanceof CompositeSurface;
    }

    public void setCompositeSurface(CompositeSurface compositeSurface) {
        super.setObject(compositeSurface);
    }

    public CompositeSolid getCompositeSolid() {
        return isSetCompositeSolid() ? (CompositeSolid) getObject() : null;
    }

    public boolean isSetCompositeSolid() {
        return getObject() instanceof CompositeSolid;
    }

    public void setCompositeSolid(CompositeSolid compositeSolid) {
        super.setObject(compositeSolid);
    }
}
