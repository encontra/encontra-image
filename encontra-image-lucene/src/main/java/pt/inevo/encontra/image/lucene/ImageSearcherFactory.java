package pt.inevo.encontra.image.lucene;

import pt.inevo.encontra.image.IndexedImage;
import pt.inevo.encontra.image.descriptors.CEDDDescriptor;
import pt.inevo.encontra.image.descriptors.FCTHDescriptor;
import pt.inevo.encontra.index.search.Searcher;

public class ImageSearcherFactory {
      /**
     * Creates a new simple image searcher.
     *
     * @return the searcher instance
     */
    public static <O extends IndexedImage> Searcher<O> createSimpleSearcher() {
        return new SimpleImageSearcher<O>();
    }


    /**
     * Returns a new ImageSearcher with the given number of maximum hits
     * which only takes the overall color into account. texture and color
     * distribution are ignored.
     *
     * @return the ImageSearcher
     * @see Searcher
     */
    public static <O extends IndexedImage> Searcher<O>  createColorOnlySearcher() {
        return createWeightedSearcher(1f, 1f, 0f);
    }

    /**
     * Returns a new ImageSearcher with the given number of maximum hits and
     * the specified weights on the different matching aspects. All weights
     * should be in [0,1] whereas a weight of 0 implies that the feature is
     * not taken into account for searching. Note that the effect is relative and
     * can only be fully applied if the {@link DocumentBuilderFactory#getExtensiveDocumentBuilder() extensive DocumentBuilder}
     * is used.
     *
     * @param colorHistogramWeight    a weight in [0,1] defining the importance of overall color in the images
     * @param colorDistributionWeight a weight in [0,1] defining the importance of color distribution (which color where) in the images
     * @param textureWeight           defining the importance of texture (which edges where) in the images
     * @return the searcher instance or NULL if the weights are not appropriate, eg. all 0 or not in [0,1]
     */
    public static <O extends IndexedImage> Searcher<O> createWeightedSearcher(
                                                       float colorHistogramWeight,
                                                       float colorDistributionWeight,
                                                       float textureWeight) {
        if (isAppropriateWeight(colorHistogramWeight)
                && isAppropriateWeight(colorDistributionWeight)
                && isAppropriateWeight(textureWeight)
                && (colorHistogramWeight + colorDistributionWeight + textureWeight > 0f))
            return new SimpleImageSearcher<O>(colorHistogramWeight, colorDistributionWeight, textureWeight){};
        else
            return null;
    }

    /**
     * Create and return an ImageSearcher for the {@link net.semanticmetadata.lire.imageanalysis.AutoColorCorrelogram}
     * image feature. Be sure to use the same options for the ImageSearcher as you used for the DocumentBuilder.
     *
     * @return
     */
    public static <O extends IndexedImage> Searcher<O> createDefaultCorrelogramImageSearcher() {
        return null;//new CorrelogramImageSearcher(maximumHits, AutoColorCorrelogram.Mode.SuperFast);
    }

    /**
     * Create and return an ImageSearcher for the {@link net.semanticmetadata.lire.imageanalysis.AutoColorCorrelogram}
     * image feature. Be sure to use the same options for the ImageSearcher as you used for the DocumentBuilder.
     *
     * @return
     */
    public static <O extends IndexedImage>  Searcher<O> createFastCorrelogramImageSearcher() {
        return null;//new CorrelogramImageSearcher(maximumHits, AutoColorCorrelogram.Mode.SuperFast);
    }

    /**
     * Create and return an ImageSearcher for the {@link net.semanticmetadata.lire.imageanalysis.CEDD}
     * image feature. Be sure to use the same options for the ImageSearcher as you used for the DocumentBuilder.
     *
     * @return
     */
    public static <O extends IndexedImage> Searcher<O> createCEDDImageSearcher(Class<O> objClass) {
        return new GenericImageSearcher<O,CEDDDescriptor<O>>(objClass){};
    }


    /**
     * Create and return an ImageSearcher for the {@link net.semanticmetadata.lire.imageanalysis.FCTH}
     * image feature. Be sure to use the same options for the ImageSearcher as you used for the DocumentBuilder.
     *
     * @return
     */
    public static <O extends IndexedImage>  Searcher<O> createFCTHImageSearcher(Class<O> objClass) {
        return new GenericImageSearcher<O, FCTHDescriptor<O>>(objClass){};
    }


    /**
     * Create and return an ImageSearcher for the {@link net.semanticmetadata.lire.imageanalysis.SimpleColorHistogram}
     * image feature. Be sure to use the same options for the ImageSearcher as you used for the DocumentBuilder.
     *
     * @return
     */
    public Searcher  createColorHistogramImageSearcher() {
        return null; //new GenericImageSearcher(maximumHits, SimpleColorHistogram.class, DocumentBuilder.FIELD_NAME_COLORHISTOGRAM);
    }

    /**
     * Create and return an ImageSearcher for the {@link net.semanticmetadata.lire.imageanalysis.Tamura}
     * image feature. Be sure to use the same options for the ImageSearcher as you used for the DocumentBuilder.
     *
     * @return
     */
    public Searcher  createTamuraImageSearcher() {
        return null; //new GenericImageSearcher(maximumHits, Tamura.class, DocumentBuilder.FIELD_NAME_TAMURA);
    }

    /**
     * Create and return an ImageSearcher for the {@link net.semanticmetadata.lire.imageanalysis.Gabor}
     * image feature. Be sure to use the same options for the ImageSearcher as you used for the DocumentBuilder.
     *
     * @param maximumHits
     * @return
     */
    public Searcher createGaborImageSearcher(int maximumHits) {
        return null; //new GenericImageSearcher(maximumHits, Gabor.class, DocumentBuilder.FIELD_NAME_GABOR);
    }


    /**
     * Checks if the weight is in [0,1]
     *
     * @param f the weight to check
     * @return true if the weight is in [0,1], false otherwise
     */
    private static boolean isAppropriateWeight(float f) {
        boolean result = false;
        if (f <= 1f && f >= 0) result = true;
        return result;

    }
}
