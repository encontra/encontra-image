package pt.inevo.encontra.image.descriptors;

import java.awt.image.BufferedImage;
import net.semanticmetadata.lire.imageanalysis.FCTH;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

public class FCTHDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {

    public FCTHDescriptor(){
        this("");
    }

    public FCTHDescriptor(String id){
        super(id, FCTHDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return FCTH.class;
    }

    public String getType() {
        return FCTHDescriptor.class.getCanonicalName();
    }
}