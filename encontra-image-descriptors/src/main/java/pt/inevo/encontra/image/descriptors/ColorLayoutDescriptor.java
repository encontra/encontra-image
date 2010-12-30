package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.ColorLayout;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

public class ColorLayoutDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {
    // numCCoeff = 28, numYCoeff = 64 <=>

    public ColorLayoutDescriptor() {
        this("");
    }
    public ColorLayoutDescriptor(String id) {
        super(id, ColorLayoutDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(origin);
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return ColorLayout.class;
    }

    public String getType() {
        return ColorLayoutDescriptor.class.getCanonicalName();
    }
}