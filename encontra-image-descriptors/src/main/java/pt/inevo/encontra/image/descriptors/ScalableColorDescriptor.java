package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.VisualDescriptor;
import net.semanticmetadata.lire.imageanalysis.ScalableColor;

/**
 *
 * @author ricardo
 */
public class ScalableColorDescriptor extends LireVisualDescriptor {

    public ScalableColorDescriptor(String id) {
        super(id);
    }

    @Override
    protected Class<? extends VisualDescriptor> getVisualDescriptorImplClass() {
        return ScalableColor.class;
    }

    @Override
    public void setValue(Object o) {
        descriptor=new ScalableColor();
        descriptor.setStringRepresentation((String) o);
    }
}