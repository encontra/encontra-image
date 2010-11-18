package pt.inevo.encontra.image.lucene.test;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Test the creation of an ImageObject (with the underlying Document from Lucene)
 * @author ricardo
 */
public class SearchIndexTest extends TestCase {
   
    public SearchIndexTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void test(){

    }

    /*
    public void testMain() throws FileNotFoundException, IOException {
        IndexReader reader = IndexReader.open(new SimpleFSDirectory(new File("test-index-path-small"), new NoLockFactory()));
        int numDocs = reader.numDocs();
        System.out.println("numDocs = " + numDocs);
        SimpleSearcher searcher = new SimpleSearcher(10);

        InputStream imageStream = getClass().getResourceAsStream("/images/img01.jpg");
//        FileInputStream imageStream = new FileInputStream("/home/ricardo/ColaDI/EnContRA/additional_images/27/27754.jpg");
        BufferedImage bimg = ImageIO.read(imageStream);
        SimpleSearchHits hits = null;
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            hits = searcher.search(bimg, reader);
        }
        time = System.currentTimeMillis() - time;
        System.out.println(((float) time / (float) 1) + " ms per search with image, averaged on " + 1);
        for (int i = 0; i < hits.length(); i++) {
            System.out.println(hits.score(i) + ": " + hits.doc(i).getField("IDENTIFIER").stringValue());
        }
        Document document = hits.doc(0);
        time = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            hits = searcher.search(document, reader);
        }
        time = System.currentTimeMillis() - time;
        System.out.println(((float) time / (float) 1) + " ms per search with document, averaged on " + 1);
        for (int i = 0; i < 3; i++) {
            System.out.println(hits.score(i) + ": " + hits.doc(i).getField("IDENTIFIER").stringValue());
        }

        ImageObject obj = new ImageObject<String>(getClass().getResource("/images/img01.jpg").getPath(),bimg);
        LuceneEncontraIndex<ImageObject> index=new LuceneEncontraIndex<ImageObject>("lucene",ImageObject.class);
        LuceneDescriptor entry = index.new LuceneIndexEntryBuilder(new EncontraDescriptor[] {
                new ScalableColorDescriptor("SCALABLECOLOR"),
                new ColorLayoutDescriptor("COLORLAYOUT"),
                new EdgeHistogramDescriptor("EDGEHISTOGRAM")
        }).createIndexEntry(obj);
        time = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            hits = searcher.search(document, reader);
        }
        time = System.currentTimeMillis() - time;
        System.out.println(((float) time / (float) 1) + " ms per search with document, averaged on " + 1);
        for (int i = 0; i < 3; i++) {
            System.out.println(hits.score(i) + ": " + hits.doc(i).getField("IDENTIFIER").stringValue());
        }
    } */
}
