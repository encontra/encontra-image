package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.descriptors.Descriptor;
import pt.inevo.encontra.descriptors.DescriptorExtractor;
import pt.inevo.encontra.image.IndexedImage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


abstract class LireVisualDescriptor<O extends IndexedImage> extends DescriptorExtractor<O,LireVisualDescriptor> implements Descriptor {

    protected LireFeature descriptor=null;
    protected String name;
    protected Serializable id;

     public LireVisualDescriptor(String name){
         super();
         this.name=name;
         try {
             descriptor=getVisualDescriptorImplClass().newInstance();
         } catch (InstantiationException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         } catch (IllegalAccessException e) {
             e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
         }
     }

    @Override
    public Serializable getId() {
        return this.id;
    }

    @Override
    public void setId(Serializable id) {
        this.id=id;
    }

    protected LireFeature getVisualDescriptorImpl(){
        return descriptor;
    }

    protected abstract Class<? extends LireFeature> getVisualDescriptorImplClass();


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
            setId(object.getId());
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
