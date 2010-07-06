/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.inevo.encontra.image.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import pt.inevo.encontra.descriptors.EncontraDescriptor;
import pt.inevo.encontra.image.ImageObject;
import pt.inevo.encontra.image.descriptors.ColorLayoutDescriptor;
import pt.inevo.encontra.image.descriptors.EdgeHistogramDescriptor;
import pt.inevo.encontra.image.descriptors.ScalableColorDescriptor;
import pt.inevo.encontra.lucene.SimpleSearcher;
import pt.inevo.encontra.lucene.index.SimpleResult;
import pt.inevo.encontra.lucene.index.SimpleSearchHits;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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
