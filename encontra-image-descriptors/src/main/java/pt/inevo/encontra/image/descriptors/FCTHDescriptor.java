package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.FCTH;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

/**
 *
 * @author ricardo
 */
public class FCTHDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {

    public FCTHDescriptor(){
        super("FCTH", FCTHDescriptor.class, IndexedObject.class);
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return FCTH.class;
    }
}