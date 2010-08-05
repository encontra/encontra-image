package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.VisualDescriptor;
import java.awt.image.BufferedImage;
import net.semanticmetadata.lire.imageanalysis.ScalableColor;
import pt.inevo.encontra.index.IndexedObject;

/**
 *
 * @author ricardo
 */
public class ScalableColorDescriptor extends LireVisualDescriptor {

    public ScalableColorDescriptor() {
        this("");
    }

    public ScalableColorDescriptor(String id) {
        super(id, ScalableColorDescriptor.class, IndexedObject.class);
        super.getVisualDescriptorImpl().extract(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
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