/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.inevo.encontra.image.lucene;


import pt.inevo.encontra.descriptors.Descriptor;
import pt.inevo.encontra.descriptors.DescriptorExtractor;
import pt.inevo.encontra.image.IndexedImage;
import pt.inevo.encontra.image.descriptors.CEDDDescriptor;
import pt.inevo.encontra.index.search.SimpleSearcher;
import pt.inevo.encontra.lucene.index.LuceneIndex;
import pt.inevo.encontra.reflection.Instantiator;


/**
 *
 */
public class GenericImageSearcher<O extends IndexedImage,D extends DescriptorExtractor & Descriptor> extends SimpleSearcher<O> {

    public GenericImageSearcher(Class<O> objClass) {
        try {
            Class<D> descriptorClass=Instantiator.getTemplateClass(this,1);
            D descriptor=descriptorClass.newInstance();
            descriptor.setIndexObjectClass(objClass);
            LuceneIndex index=new LuceneIndex(descriptor.getName()+"-index",descriptorClass);
            index.load(descriptor.getName()+"-index");
            this.setIndex(index);
            setDescriptorExtractor(descriptor);
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }


}
