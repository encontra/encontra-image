/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.inevo.encontra.image.lucene;


import pt.inevo.encontra.descriptors.EncontraDescriptor;
import pt.inevo.encontra.image.ImageObject;
import pt.inevo.encontra.image.descriptors.ColorLayoutDescriptor;
import pt.inevo.encontra.image.descriptors.EdgeHistogramDescriptor;
import pt.inevo.encontra.image.descriptors.ScalableColorDescriptor;
import pt.inevo.encontra.index.search.SimpleSearcher;


/**
 *
 */
public class SimpleImageSearcher extends SimpleSearcher<EncontraDescriptor<ImageObject>> { //<O extends ImageObject> {


    public SimpleImageSearcher(int maxHits) {
        super(maxHits);
    }

    public SimpleImageSearcher(int maxHits,
                               float colorHistogramWeight,
                               float colorDistributionWeight,
                               float textureWeight) {
        super(maxHits);

        addDescriptor(new ScalableColorDescriptor("SCALABLECOLOR"),colorHistogramWeight);
        addDescriptor(new ColorLayoutDescriptor("COLORLAYOUT"),colorDistributionWeight);
        addDescriptor(new EdgeHistogramDescriptor("EDGEHISTOGRAM"),textureWeight);
    }

}
