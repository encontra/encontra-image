package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.ColorLayoutImpl;
import at.lux.imageanalysis.VisualDescriptor;
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
    protected VisualDescriptor getVisualDescriptorImpl() {
        return new ColorLayoutImpl(); 
    }

    public String getType() {
        return ColorLayoutDescriptor.class.getCanonicalName();
    }


}