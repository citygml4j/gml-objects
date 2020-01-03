package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.Envelope;

public class Rectangle extends AbstractSurfacePatch {
    private AbstractRingProperty exterior;

    public Rectangle() {
    }

    public Rectangle(AbstractRingProperty exterior) {
        setExterior(exterior);
    }

    public Rectangle(AbstractRing exterior) {
        this(new AbstractRingProperty(exterior));
    }

    public AbstractRingProperty getExterior() {
        return exterior;
    }

    public void setExterior(AbstractRingProperty exterior) {
        this.exterior = asChild(exterior);
    }

    public SurfaceInterpolation getInterpolation() {
        return SurfaceInterpolation.PLANAR;
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (exterior != null && exterior.getObject() != null)
            envelope.include(exterior.getObject().computeEnvelope());

        return envelope;
    }
}
