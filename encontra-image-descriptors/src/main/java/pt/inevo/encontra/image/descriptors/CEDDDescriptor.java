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
        this(CEDDDescriptor.class.getCanonicalName());
        this.name = CEDDDescriptor.class.getCanonicalName();
    }

    public CEDDDescriptor(String id){
        super(id, CEDDDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(origin);
        if (id.equals("")) this.name = CEDDDescriptor.class.getCanonicalName();
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return CEDD.class;
    }

    public String getType() {
        return CEDDDescriptor.class.getCanonicalName();
    }
}