package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.LireFeature;
import net.semanticmetadata.lire.imageanalysis.ScalableColor;
import pt.inevo.encontra.index.IndexedObject;

public class ScalableColorDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {

    public ScalableColorDescriptor() {
        this(ScalableColorDescriptor.class.getCanonicalName());
        this.name = ScalableColorDescriptor.class.getCanonicalName();
    }

    public ScalableColorDescriptor(String id) {
        super(id, ScalableColorDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(origin);
        if (id.equals(""))this.name = ScalableColorDescriptor.class.getCanonicalName();
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return ScalableColor.class;
    }

    public String getType() {
        return ScalableColorDescriptor.class.getCanonicalName();
    }
}