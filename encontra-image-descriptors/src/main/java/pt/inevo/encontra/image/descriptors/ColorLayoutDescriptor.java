package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.ColorLayoutImpl;
import at.lux.imageanalysis.VisualDescriptor;


/**
 *
 * @author ricardo
 */
public class ColorLayoutDescriptor extends LireVisualDescriptor {

    
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