package pt.inevo.encontra.image.lucene.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import junit.framework.TestCase;


/**
 * Test the creation of an ImageObject (with the underlying Document from Lucene)
 * @author ricardo
 */
public class CreateIndexTest extends TestCase {

    public CreateIndexTest(String testName) {
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

        /**
     * this method returns all images from a directory in an arrayList
     * @param directory the directory where all images should be found
     * @param descendIntoSubDirectories - decides if subdirectories should be used also
     * @return the filenames as ArrayList<String>
     * @throws IOException
     */
    public static ArrayList<String> getAllImages(File directory, boolean descendIntoSubDirectories) throws IOException {
        ArrayList<String> resultList = new ArrayList<String>(256);
        File[] f = directory.listFiles();
        for (File file : f) {
            if (file != null && (file.getName().toLowerCase().endsWith(".jpg") || file.getName().toLowerCase().endsWith(".JPG")) && !file.getName().startsWith("tn_")) {
                resultList.add(file.getCanonicalPath());
            }
            if (descendIntoSubDirectories && file.isDirectory()) {
                ArrayList<String> tmp = getAllImages(file, true);
                if (tmp != null) {
                    resultList.addAll(tmp);
                }
            }
        }
        if (resultList.size() > 0) {
            return resultList;
        } else {
            return null;
        }
    }

    /*
    public void testMain() throws FileNotFoundException, CorruptIndexException, IOException {
       LuceneEncontraDocumentBuilder builder = new LuceneEncontraDocumentBuilder(new EncontraDescriptor[] {
               new ScalableColorDescriptor("SCALABLECOLOR"),
               new ColorLayoutDescriptor("COLORLAYOUT"),
                new EdgeHistogramDescriptor("EDGEHISTOGRAM")
       });
        IndexWriter iw = new IndexWriter(FSDirectory.open(new File("test-index-path-small")), new SimpleAnalyzer(), true, IndexWriter.MaxFieldLength.UNLIMITED);
        for (String identifier : getAllImages(new File(getClass().getResource("/images").getPath()), true)) {
            System.out.println("Indexing file " + identifier);
            ImageObject<String> object = new ImageObject<String>();
            object.setId(identifier);
            object.setImage(identifier);
            Document doc = builder.createDocument(object);
            iw.addDocument(doc);
        }
        iw.optimize();
        iw.close();
    }*/
}
