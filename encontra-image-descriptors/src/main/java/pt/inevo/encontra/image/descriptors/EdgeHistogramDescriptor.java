package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.VisualDescriptor;
import net.semanticmetadata.lire.imageanalysis.EdgeHistogram;
import pt.inevo.encontra.index.IndexedObject;

public class EdgeHistogramDescriptor extends LireVisualDescriptor {
    public EdgeHistogramDescriptor(String id) {
        super(id, EdgeHistogramDescriptor.class, IndexedObject.class);
    }

    @Override
     protected Class<? extends VisualDescriptor> getVisualDescriptorImplClass() {
        return EdgeHistogram.class;
    }

    public String getType() {
        return EdgeHistogramDescriptor.class.getCanonicalName();
    }

    @Override
    public LireVisualDescriptor extract(IndexedObject object) {
        this.descriptor=new EdgeHistogram();
        return super.extract(object);
    }
}