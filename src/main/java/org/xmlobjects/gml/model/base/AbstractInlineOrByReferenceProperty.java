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

package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.xlink.ActuateType;
import org.xmlobjects.gml.model.xlink.ShowType;
import org.xmlobjects.model.Child;

public abstract class AbstractInlineOrByReferenceProperty<T extends Child> extends AbstractAssociation<T> implements AssociationAttributes {
    private T object;
    private String href;
    private String role;
    private String arcRole;
    private String title;
    private ShowType show;
    private ActuateType actuate;
    private NilReason nilReason;
    private String remoteSchema;

    public AbstractInlineOrByReferenceProperty() {
    }

    public AbstractInlineOrByReferenceProperty(T object) {
        setObject(object);
    }

    public AbstractInlineOrByReferenceProperty(String href) {
        this.href = href;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = asChild(object);
    }

    public void setObjectIfValid(Child object) {
        if (getTargetType().isInstance(object))
            setObject(getTargetType().cast(object));
    }

    public void setReference(AssociationAttributes reference) {
        href = reference.getHref();
        role = reference.getRole();
        arcRole = reference.getArcRole();
        title = reference.getTitle();
        show = reference.getShow();
        actuate = reference.getActuate();
        nilReason = reference.getNilReason();
        remoteSchema = reference.getRemoteSchema();
    }

    @Override
    public final String getType() {
        return "simple";
    }

    @Override
    public String getHref() {
        return href;
    }

    @Override
    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getArcRole() {
        return arcRole;
    }

    @Override
    public void setArcRole(String arcRole) {
        this.arcRole = arcRole;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public ShowType getShow() {
        return show;
    }

    @Override
    public void setShow(ShowType show) {
        this.show = show;
    }

    @Override
    public ActuateType getActuate() {
        return actuate;
    }

    @Override
    public void setActuate(ActuateType actuate) {
        this.actuate = actuate;
    }

    @Override
    public NilReason getNilReason() {
        return nilReason;
    }

    @Override
    public void setNilReason(NilReason nilReason) {
        this.nilReason = asChild(nilReason);
    }

    @Override
    public String getRemoteSchema() {
        return remoteSchema;
    }

    @Override
    public void setRemoteSchema(String remoteSchema) {
        this.remoteSchema = remoteSchema;
    }
}
