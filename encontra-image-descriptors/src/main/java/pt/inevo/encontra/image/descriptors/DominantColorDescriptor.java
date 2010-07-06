package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.DominantColorImplementation;
import at.lux.imageanalysis.VisualDescriptor;

/**
 *
 * @author ricardo
 */
public class DominantColorDescriptor extends LireVisualDescriptor {

    public DominantColorDescriptor(String id) {
        super(id);
    }

    @Override
    protected VisualDescriptor getVisualDescriptorImpl() {
        return null; // new DominantColorImplementation();
    }

    public String getType() {
        return DominantColorDescriptor.class.getCanonicalName();
    }

   

}