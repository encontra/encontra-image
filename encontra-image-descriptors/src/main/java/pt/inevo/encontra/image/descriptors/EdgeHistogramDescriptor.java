package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.EdgeHistogramImplementation;
import at.lux.imageanalysis.VisualDescriptor;


public class EdgeHistogramDescriptor extends LireVisualDescriptor {
    public EdgeHistogramDescriptor(String id) {
        super(id);
    }

    @Override
    protected VisualDescriptor getVisualDescriptorImpl() {
        return new EdgeHistogramImplementation();
    }

    public String getType() {
        return EdgeHistogramDescriptor.class.getCanonicalName();
    }

}
