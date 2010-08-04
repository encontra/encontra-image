package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.CEDD;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

/**
 *
 * @author ricardo
 */
public class CEDDDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {

    public CEDDDescriptor(){
        super("CEDD");
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return CEDD.class;
    }
}