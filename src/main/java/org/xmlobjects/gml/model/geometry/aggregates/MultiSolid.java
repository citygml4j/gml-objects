package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSolid;
import org.xmlobjects.gml.model.geometry.primitives.SolidArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MultiSolid extends AbstractGeometricAggregate {
    private List<SolidProperty> solidMember;
    private SolidArrayProperty solidMembers;

    public MultiSolid() {
    }

    public MultiSolid(List<SolidProperty> solidMember) {
        setSolidMember(solidMember);
    }

    public List<SolidProperty> getSolidMember() {
        if (solidMember == null)
            solidMember = new ChildList<>(this);

        return solidMember;
    }

    public void setSolidMember(List<SolidProperty> solidMember) {
        this.solidMember = asChild(solidMember);
    }

    public SolidArrayProperty getSolidMembers() {
        return solidMembers;
    }

    public void setSolidMembers(SolidArrayProperty solidMembers) {
        this.solidMembers = asChild(solidMembers);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (solidMember != null) {
            for (SolidProperty property : solidMember) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope());
            }
        }

        if (solidMembers != null) {
            for (AbstractSolid solid : solidMembers.getObjects())
                envelope.include(solid.computeEnvelope());
        }

        return envelope;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
