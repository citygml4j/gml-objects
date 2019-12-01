package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.primitives.SurfaceArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MultiSurface extends AbstractGeometricAggregate {
    private List<SurfaceProperty> surfaceMember;
    private SurfaceArrayProperty surfaceMembers;

    public MultiSurface() {
    }

    public MultiSurface(List<SurfaceProperty> surfaceMember) {
        setSurfaceMember(surfaceMember);
    }

    public List<SurfaceProperty> getSurfaceMember() {
        if (surfaceMember == null)
            surfaceMember = new ChildList<>(this);

        return surfaceMember;
    }

    public void setSurfaceMember(List<SurfaceProperty> surfaceMember) {
        this.surfaceMember = asChild(surfaceMember);
    }

    public SurfaceArrayProperty getSurfaceMembers() {
        return surfaceMembers;
    }

    public void setSurfaceMembers(SurfaceArrayProperty surfaceMembers) {
        this.surfaceMembers = asChild(surfaceMembers);
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
