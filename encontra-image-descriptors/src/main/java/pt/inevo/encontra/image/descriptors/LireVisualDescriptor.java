package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.VisualDescriptor;
import pt.inevo.encontra.descriptors.Descriptor;
import pt.inevo.encontra.descriptors.DescriptorExtractor;
import pt.inevo.encontra.image.ImageObject;
import pt.inevo.encontra.index.AbstractObject;
import pt.inevo.encontra.index.IndexedObject;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


abstract class LireVisualDescriptor<O extends IndexedObject> implements Descriptor<String>, DescriptorExtractor<O,LireVisualDescriptor> {

    protected VisualDescriptor descriptor=null;
    protected String id;
    
    public LireVisualDescriptor() {
        this(null);
    }
    public LireVisualDescriptor(String id) {
        this.id=id;
        descriptor=getVisualDescriptorImpl();
    }

    @Override
    public String getId() {
        return id;
    }

    protected abstract VisualDescriptor getVisualDescriptorImpl();

    @Override
    public LireVisualDescriptor newDescriptor(Class<LireVisualDescriptor> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LireVisualDescriptor extract(O object){
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
        return this;
    }

    @Override
    public double getDistance(Descriptor<String> other) {
       return descriptor.getDistance( ((LireVisualDescriptor)other).getVisualDescriptorImpl());
    }

    @Override
    public String getStringRepresentation() {
        return descriptor.getStringRepresentation();
    }


    @Override
    public Descriptor<String> setStringRepresentation(String d) {
        descriptor.setStringRepresentation(d);
        return this;
    }



    @Override
    public Descriptor<String>  clone() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object o) {
        throw new NotImplementedException();
    }


    @Override
    public Serializable getValue() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setValue(Serializable o) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
