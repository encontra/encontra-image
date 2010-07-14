package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.ScalableColorImpl;
import at.lux.imageanalysis.VisualDescriptor;

/**
 *
 * @author ricardo
 */
public class ScalableColorDescriptor extends LireVisualDescriptor {

    public ScalableColorDescriptor(String id) {
        super(id);
    }

    @Override
    protected VisualDescriptor getVisualDescriptorImpl() {
        return new ScalableColorImpl();  //To change body of implemented methods use File | Settings | File Templates.
    }


}