package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.FCTH;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

public class FCTHDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {

    public FCTHDescriptor(){
        this(FCTHDescriptor.class.getCanonicalName());
        this.name = FCTHDescriptor.class.getCanonicalName();
    }

    public FCTHDescriptor(String id){
        super(id, FCTHDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(origin);
        if (id.equals("")) this.name = FCTHDescriptor.class.getCanonicalName();
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return FCTH.class;
    }

    public String getType() {
        return FCTHDescriptor.class.getCanonicalName();
    }
}