package pt.inevo.encontra.image.descriptors;

import java.awt.image.BufferedImage;
import net.semanticmetadata.lire.imageanalysis.EdgeHistogram;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

public class EdgeHistogramDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {
    
    public EdgeHistogramDescriptor() {
        this("");
    }

    public EdgeHistogramDescriptor(String id) {
        super(id, EdgeHistogramDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return EdgeHistogram.class;
    }

    public String getType() {
        return EdgeHistogramDescriptor.class.getCanonicalName();
    }
}