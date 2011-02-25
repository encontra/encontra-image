package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.ColorLayout;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

public class ColorLayoutDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {
    // numCCoeff = 28, numYCoeff = 64 <=>

    public ColorLayoutDescriptor() {
        this(ColorLayoutDescriptor.class.getCanonicalName());
        this.name = ColorLayoutDescriptor.class.getCanonicalName();
    }
    public ColorLayoutDescriptor(String id) {
        super(id, ColorLayoutDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(origin);
        if (id.equals(""))this.name = ColorLayoutDescriptor.class.getCanonicalName();
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return ColorLayout.class;
    }

    public String getType() {
        return ColorLayoutDescriptor.class.getCanonicalName();
    }
}