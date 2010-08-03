package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.descriptors.Descriptor;
import pt.inevo.encontra.descriptors.DescriptorExtractor;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import pt.inevo.encontra.index.IndexedObject;

abstract class LireVisualDescriptor<O extends IndexedObject> extends DescriptorExtractor<O, LireVisualDescriptor> implements Descriptor {

    protected LireFeature descriptor = null;
    protected String name;
    protected Serializable id;

    public LireVisualDescriptor(String name) {
        super();
        this.name = name;
        try {
            descriptor = getVisualDescriptorImplClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Serializable getId() {
        return this.id;
    }

    @Override
    public void setId(Serializable id) {
        this.id = id;
    }

    protected LireFeature getVisualDescriptorImpl() {
        return descriptor;
    }

    protected abstract Class<? extends LireFeature> getVisualDescriptorImplClass();

    @Override
    protected O setupIndexedObject(LireVisualDescriptor descriptor, O object) {
        object.setId(descriptor.getId());
        return object;
    }

    @Override
    public LireVisualDescriptor extract(O object) {
        try {
            Method extractor = descriptor.getClass().getMethod("extract", BufferedImage.class); //There is no common interface with the extract method
            extractor.invoke(descriptor, (BufferedImage) object.getValue());
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
        return getVisualDescriptorImpl().getDistance(((LireVisualDescriptor) other).getVisualDescriptorImpl());
    }

    @Override
    public Descriptor clone() {
        throw new NotImplementedException();
    }

    @Override
    public Serializable getValue() {
        return descriptor.getStringRepresentation();
    }

    @Override
    public void setValue(Object o) {
        descriptor.setStringRepresentation((String) o);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double[] getDoubleRepresentation() {
        String stringRep = descriptor.getStringRepresentation();
        String [] strValues = stringRep.split("z");

        int totalLength = 0;
        for (int i = 0; i < strValues.length ; i++){
            String [] parcValues = strValues[i].split(" ");
            totalLength += parcValues.length;
        }
        double[] result = new double[totalLength];

        for (int i = 0; i < strValues.length ; ){
            String [] parcValues = strValues[i].split(" ");
            for (int j = 0; j < parcValues.length ; j++, i++){
                result[i] = (Double.parseDouble(parcValues[j]));
            }
        }

        return result;
    }

    @Override
    public void setDoubleRepresentation(double[] values){
        //TO DO - must fix this, because it will not work
        String strRep = "";
        for (int i = 0; i < values.length ; i++){
            strRep += values[i] + " ";
        }
        descriptor.setStringRepresentation(strRep);
    }

    private void writeObject(ObjectOutputStream out)
            throws IOException {
        out.writeObject(id);
        out.writeChars(name);
        out.writeChars(descriptor.getStringRepresentation());
    }

    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        id = (Serializable)in.readObject();
        name = in.readUTF();
        descriptor.setStringRepresentation(in.readUTF());
    }
}
