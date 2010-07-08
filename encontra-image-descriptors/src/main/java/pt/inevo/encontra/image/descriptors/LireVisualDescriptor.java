package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.ColorLayoutImpl;
import at.lux.imageanalysis.VisualDescriptor;
import pt.inevo.encontra.descriptors.EncontraDescriptor;
import pt.inevo.encontra.image.ImageObject;

import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


abstract class LireVisualDescriptor extends EncontraDescriptor<ImageObject> {
    VisualDescriptor descriptor=null;
    
    public LireVisualDescriptor() {
        this(null);
    }
    public LireVisualDescriptor(String id) {
        super(id);
        descriptor=getVisualDescriptorImpl();
    }

    protected abstract VisualDescriptor getVisualDescriptorImpl();

    public String getType() {
        return ColorLayoutDescriptor.class.getCanonicalName();
    }

    public VisualDescriptor getVisualDescriptor(){
        return descriptor;
    }
    @Override
    public boolean extract(ImageObject object){
        try {
            Method [] methods=descriptor.getClass().getMethods();
            Method extractor=descriptor.getClass().getMethod("extract",BufferedImage.class); //There is no common interface with the extract method 

            extractor.invoke(descriptor,object.getObject());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public double getDistance(EncontraDescriptor<ImageObject> other) {       
        return descriptor.getDistance( ((LireVisualDescriptor)other).getVisualDescriptor());
    }

    @Override
    public String getStringRepresentation() {
        return descriptor.getStringRepresentation();
    }

    @Override
    public double[] getDoubleRepresentation() {
        //TO DO
        return new double [1];
    }

    @Override
    public EncontraDescriptor<ImageObject> setStringRepresentation(String d) {
        descriptor.setStringRepresentation(d);
        return this;
    }
}
