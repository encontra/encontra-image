package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

/**
 *
 * @author ricardo
 */
public class DominantColorDescriptor extends LireVisualDescriptor {

    public DominantColorDescriptor(String id) {
        super(id, DominantColorDescriptor.class, IndexedObject.class);
    }

    @Override
     protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return null; // new DominantColorImplementation();
    }

    public String getType() {
        return DominantColorDescriptor.class.getCanonicalName();
    }
}