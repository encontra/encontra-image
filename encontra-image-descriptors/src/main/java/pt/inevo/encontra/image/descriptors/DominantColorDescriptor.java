package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.DominantColorImplementation;
import net.semanticmetadata.lire.imageanalysis.LireFeature;

/**
 *
 * @author ricardo
 */
public class DominantColorDescriptor extends LireVisualDescriptor {

    public DominantColorDescriptor(String id) {
        super(id);
    }

    @Override
     protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return null; // new DominantColorImplementation();
    }

    public String getType() {
        return DominantColorDescriptor.class.getCanonicalName();
    }

   

}