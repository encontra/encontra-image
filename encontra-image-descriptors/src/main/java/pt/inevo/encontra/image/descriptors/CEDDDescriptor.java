package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.VisualDescriptor;
import net.semanticmetadata.lire.imageanalysis.CEDD;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import net.semanticmetadata.lire.imageanalysis.ScalableColor;
import pt.inevo.encontra.image.IndexedImage;

/**
 *
 * @author ricardo
 */
public class CEDDDescriptor<O extends IndexedImage> extends LireVisualDescriptor<O> {

    public CEDDDescriptor(){
        super("CEDD");
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return CEDD.class;
    }

}