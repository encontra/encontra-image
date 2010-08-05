package pt.inevo.encontra.image.descriptors;

import java.awt.image.BufferedImage;
import net.semanticmetadata.lire.imageanalysis.ColorLayout;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.index.IndexedObject;

public class ColorLayoutDescriptor<O extends IndexedObject> extends LireVisualDescriptor<O> {
    // numCCoeff = 28, numYCoeff = 64 <=> 

    public ColorLayoutDescriptor() {
        this("");
    }
    public ColorLayoutDescriptor(String id) {
        super(id);
        super.getVisualDescriptorImpl().extract(new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
        super.indexObjectClass = (Class<O>) IndexedObject.class;
    }

    @Override
    protected Class<? extends LireFeature> getVisualDescriptorImplClass() {
        return ColorLayout.class;
    }

    public String getType() {
        return ColorLayoutDescriptor.class.getCanonicalName();
    }

    @Override
    protected LireVisualDescriptor clone() {
        LireVisualDescriptor newDescriptor = new ColorLayoutDescriptor();

        newDescriptor.setId(this.id);
        newDescriptor.setValue(this.getValue());

        return newDescriptor;
    }
}