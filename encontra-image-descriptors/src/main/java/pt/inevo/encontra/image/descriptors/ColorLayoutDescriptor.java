package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.ColorLayoutImpl;
import at.lux.imageanalysis.VisualDescriptor;
import pt.inevo.encontra.image.ImageObject;
import pt.inevo.encontra.index.AbstractObject;


/**
 *
 * @author ricardo
 */
public class ColorLayoutDescriptor<O extends ImageObject> extends LireVisualDescriptor<O> {
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

    @Override
    public ColorLayoutDescriptor setStringRepresentation(String d) {
        return (ColorLayoutDescriptor) super.setStringRepresentation(d);
    }

}