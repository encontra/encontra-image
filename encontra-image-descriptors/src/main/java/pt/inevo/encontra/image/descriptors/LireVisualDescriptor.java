package pt.inevo.encontra.image.descriptors;

import net.semanticmetadata.lire.imageanalysis.LireFeature;
import pt.inevo.encontra.descriptors.Descriptor;
import pt.inevo.encontra.descriptors.DescriptorExtractor;
import pt.inevo.encontra.index.IndexedObject;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class LireVisualDescriptor<O extends IndexedObject> extends DescriptorExtractor<O, LireVisualDescriptor> implements Descriptor, Cloneable {

    protected static BufferedImage origin = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
    protected LireFeature descriptor = null;
    protected String name;
    protected Serializable id;

    public LireVisualDescriptor(String name, Class descriptorClazz, Class indexObjectClazz) {
        super();
        this.name = name;
        super.descriptorClass = descriptorClazz;
        super.indexObjectClass = indexObjectClazz;
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
        return this.clone();
    }

    @Override
    protected LireVisualDescriptor clone() {
        LireVisualDescriptor newDescriptor = null;
        try {

            newDescriptor = super.descriptorClass.newInstance();
            newDescriptor.setId(this.id);
            newDescriptor.name = name;
            newDescriptor.setValue(this.getValue());

        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return newDescriptor;
    }

    @Override
    public double getDistance(Descriptor other) {
        return getVisualDescriptorImpl().getDistance(((LireVisualDescriptor) other).getVisualDescriptorImpl());
    }

    @Override
    public double getNorm() {
        try {
            LireVisualDescriptor newDescriptor = super.descriptorClass.newInstance();
            newDescriptor.getVisualDescriptorImpl().extract(origin);
            return getVisualDescriptorImpl().getDistance(newDescriptor.getVisualDescriptorImpl());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return -1;
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

    //serializing the descriptor
    private void writeObject(ObjectOutputStream out)
            throws IOException {
        out.writeObject(id);
        out.writeUTF(name);
        out.writeUTF(descriptor.getStringRepresentation());
    }

    //desserializing the descriptor
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        id = (Serializable)in.readObject();
        name = in.readUTF();
        try {
            descriptor = getVisualDescriptorImplClass().newInstance();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        descriptor.setStringRepresentation(in.readUTF());
    }
}
