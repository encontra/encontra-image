package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.ColorLayout;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.image.IndexedImage;


/**
 *
 * @author ricardo
 */
public class ColorLayoutDescriptor<O extends IndexedImage> extends LireVisualDescriptor<O> {
    // numCCoeff = 28, numYCoeff = 64 <=> 

    public ColorLayoutDescriptor() {
        this(null);
    }
    public ColorLayoutDescriptor(String id) {
        super(id);
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return ColorLayout.class;
    }

    public String getType() {
        return ColorLayoutDescriptor.class.getCanonicalName();
    }


}