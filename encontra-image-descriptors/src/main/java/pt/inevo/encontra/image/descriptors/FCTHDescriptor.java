package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.CEDD;
import net.semanticmetadata.lire.imageanalysis.FCTH;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.image.IndexedImage;

/**
 *
 * @author ricardo
 */
public class FCTHDescriptor<O extends IndexedImage> extends LireVisualDescriptor<O> {

    public FCTHDescriptor(){
        super("FCTH");
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return FCTH.class;
    }

}