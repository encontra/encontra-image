package pt.inevo.encontra.image.descriptors;

import java.awt.image.BufferedImage;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import net.semanticmetadata.lire.imageanalysis.Tamura;
import pt.inevo.encontra.index.IndexedObject;

/**
 *
 * @author ricardo
 */
public class DominantColorDescriptor<O extends IndexedObject> extends LireVisualDescriptor {

    public DominantColorDescriptor(){
        this("");
    }

    public DominantColorDescriptor(String id) {
        super(id, DominantColorDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
    }

    @Override
     protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        /*
         TO DO - must include the Dominant Color Descriptor that exists in the
         Caliph&Emir packages.
        */
        return Tamura.class;
    }

    public String getType() {
        return DominantColorDescriptor.class.getCanonicalName();
    }
}