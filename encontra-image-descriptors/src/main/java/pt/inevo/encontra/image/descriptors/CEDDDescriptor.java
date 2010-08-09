package pt.inevo.encontra.image.descriptors;

import java.awt.image.BufferedImage;
import net.semanticmetadata.lire.imageanalysis.CEDD;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

/**
 *
 * @author ricardo
 */
public class CEDDDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {

    public CEDDDescriptor(){
        super("CEDD", CEDDDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return CEDD.class;
    }

    public String getType() {
        return CEDDDescriptor.class.getCanonicalName();
    }
}