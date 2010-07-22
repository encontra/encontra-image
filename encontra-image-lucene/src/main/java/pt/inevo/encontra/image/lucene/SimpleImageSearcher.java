/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.inevo.encontra.image.lucene;


import pt.inevo.encontra.descriptors.CompositeDescriptor;
import pt.inevo.encontra.descriptors.CompositeDescriptorExtractor;
import pt.inevo.encontra.descriptors.Descriptor;

import pt.inevo.encontra.descriptors.DescriptorExtractor;
import pt.inevo.encontra.image.IndexedImage;
import pt.inevo.encontra.image.descriptors.ColorLayoutDescriptor;
import pt.inevo.encontra.image.descriptors.EdgeHistogramDescriptor;
import pt.inevo.encontra.image.descriptors.ScalableColorDescriptor;
import pt.inevo.encontra.index.search.SimpleSearcher;
import pt.inevo.encontra.lucene.index.LuceneIndex;


/**
 *
 */
public class SimpleImageSearcher<O extends IndexedImage> extends SimpleSearcher<O> {

    double colorHistogramWeight=1.0;
    double colorDistributionWeight=1.0;
    double textureWeight=1.0;

    public static class SimpleImageDescriptor extends CompositeDescriptor {
        public SimpleImageDescriptor(){
            super(new Descriptor[]{
                    new ScalableColorDescriptor("SCALABLECOLOR"),
                    new ColorLayoutDescriptor("COLORLAYOUT"),
                    new EdgeHistogramDescriptor("EDGEHISTOGRAM")
            });
        }
    }

    public SimpleImageSearcher(double colorHistogramWeight,double colorDistributionWeight,double textureWeight) {
        super();

        this.colorHistogramWeight=colorHistogramWeight;
        this.colorDistributionWeight=colorDistributionWeight;
        this.textureWeight=textureWeight;

        LuceneIndex index=new LuceneIndex("image-index",SimpleImageDescriptor.class);
        index.load("testLuceneIndex");
        this.setIndex(index);

        CompositeDescriptorExtractor extractor=new CompositeDescriptorExtractor(IndexedImage.class, SimpleImageDescriptor.class);
        extractor.addExtractor(new ScalableColorDescriptor("SCALABLECOLOR"),colorHistogramWeight);
        extractor.addExtractor(new ColorLayoutDescriptor("COLORLAYOUT"),colorDistributionWeight);
        extractor.addExtractor(new EdgeHistogramDescriptor("EDGEHISTOGRAM"),textureWeight);
        setDescriptorExtractor(extractor);
    }
    public SimpleImageSearcher() {
        this(1.0,1.0,1.0);

    }



}
