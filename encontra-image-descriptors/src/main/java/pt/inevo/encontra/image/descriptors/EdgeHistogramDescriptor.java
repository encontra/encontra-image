package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.VisualDescriptor;
import net.semanticmetadata.lire.imageanalysis.EdgeHistogram;
import pt.inevo.encontra.descriptors.Descriptor;
import pt.inevo.encontra.image.IndexedImage;
import pt.inevo.encontra.storage.IEntity;

import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;


public class EdgeHistogramDescriptor extends LireVisualDescriptor {
    public EdgeHistogramDescriptor(String id) {
        super(id);
    }

    @Override
     protected Class<? extends VisualDescriptor> getVisualDescriptorImplClass() {
        return EdgeHistogram.class;
    }

    public String getType() {
        return EdgeHistogramDescriptor.class.getCanonicalName();
    }

    @Override
    public LireVisualDescriptor extract(IndexedImage object) {
        this.descriptor=new EdgeHistogram();
        return super.extract(object);
    }
}
