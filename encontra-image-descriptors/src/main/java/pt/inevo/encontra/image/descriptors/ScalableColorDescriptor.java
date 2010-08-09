package pt.inevo.encontra.image.descriptors;

import java.awt.image.BufferedImage;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import net.semanticmetadata.lire.imageanalysis.ScalableColor;
import pt.inevo.encontra.index.IndexedObject;

public class ScalableColorDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {

    public ScalableColorDescriptor() {
        this("");
    }

    public ScalableColorDescriptor(String id) {
        super(id, ScalableColorDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return ScalableColor.class;
    }

    public String getType() {
        return ScalableColorDescriptor.class.getCanonicalName();
    }
}