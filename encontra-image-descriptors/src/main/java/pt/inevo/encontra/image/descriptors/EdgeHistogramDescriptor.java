package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.EdgeHistogram;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

public class EdgeHistogramDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {
    
    public EdgeHistogramDescriptor() {
        this("");
    }

    public EdgeHistogramDescriptor(String id) {
        super(id, EdgeHistogramDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(origin);
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return EdgeHistogram.class;
    }

    public String getType() {
        return EdgeHistogramDescriptor.class.getCanonicalName();
    }
}