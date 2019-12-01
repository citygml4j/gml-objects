package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Curve extends AbstractCurve {
    private CurveSegmentArrayProperty segments;

    public Curve() {
    }

    public Curve(CurveSegmentArrayProperty segments) {
        setSegments(segments);
    }

    public CurveSegmentArrayProperty getSegments() {
        return segments;
    }

    public void setSegments(CurveSegmentArrayProperty segments) {
        this.segments = asChild(segments);
    }

    @Override
    public List<Double> toCoordinateList3D() {
        if (segments != null)
            return segments.getObjects().stream()
                    .filter(Objects::nonNull)
                    .map(AbstractCurveSegment::toCoordinateList3D)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        else
            return Collections.emptyList();
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
