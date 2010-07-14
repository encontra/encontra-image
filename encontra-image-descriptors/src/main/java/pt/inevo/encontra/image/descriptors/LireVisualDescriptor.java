package pt.inevo.encontra.image.descriptors;

import at.lux.imageanalysis.VisualDescriptor;
import pt.inevo.encontra.descriptors.Descriptor;
import pt.inevo.encontra.descriptors.DescriptorExtractor;
import pt.inevo.encontra.image.IndexedImage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


abstract class LireVisualDescriptor<O extends IndexedImage> extends DescriptorExtractor<O,LireVisualDescriptor> implements Descriptor {

    protected VisualDescriptor descriptor=null;
    protected String name;

     public LireVisualDescriptor(String name){
         super();
         this.name=name;
         descriptor=getVisualDescriptorImpl();
     }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void setId(Serializable id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    protected abstract VisualDescriptor getVisualDescriptorImpl();


    @Override
    protected O setupIndexedObject(LireVisualDescriptor descriptor, O object) {
        object.setId(descriptor.getId());
        return object;
    }

    @Override
    public LireVisualDescriptor extract(O object){
        try {
            Method [] methods=descriptor.getClass().getMethods();
            Method extractor=descriptor.getClass().getMethod("extract",BufferedImage.class); //There is no common interface with the extract method 

            extractor.invoke(descriptor,object.getValue());
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
    public double getDistance(Descriptor other) {
       return getVisualDescriptorImpl().getDistance( ((LireVisualDescriptor)other).getVisualDescriptorImpl());
    }


    @Override
    public Descriptor  clone() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object o) {
        throw new NotImplementedException();
    }


    @Override
    public Serializable getValue() {
        return descriptor.getStringRepresentation();
    }

    @Override
    public void setValue(Object o) {
        descriptor.setStringRepresentation((String)o);
    }

    @Override
    public String getName() {
        return name;
    }
}
