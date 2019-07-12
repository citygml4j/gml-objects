package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.primitives.CurveArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;

import java.util.List;

public class MultiCurve extends AbstractGeometricAggregate {
    private List<CurveProperty> curveMember;
    private CurveArrayProperty curveMembers;

    public MultiCurve() {
    }

    public MultiCurve(List<CurveProperty> curveMember) {
        setCurveMember(curveMember);
    }

    public List<CurveProperty> getCurveMember() {
        if (curveMember == null)
            curveMember = new ChildList<>(this);

        return curveMember;
    }

    public void setCurveMember(List<CurveProperty> curveMember) {
        this.curveMember = asChild(curveMember);
    }

    public CurveArrayProperty getCurveMembers() {
        return curveMembers;
    }

    public void setCurveMembers(CurveArrayProperty curveMembers) {
        this.curveMembers = asChild(curveMembers);
    }
}
