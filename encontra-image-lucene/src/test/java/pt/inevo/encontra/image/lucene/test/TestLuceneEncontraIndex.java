package pt.inevo.encontra.image.lucene.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import junit.framework.TestCase;
import pt.inevo.encontra.engine.Engine;
import pt.inevo.encontra.engine.SimpleEngine;
import pt.inevo.encontra.image.ImageObject;
import pt.inevo.encontra.index.AbstractObject;
import pt.inevo.encontra.index.PersistentIndex;
import pt.inevo.encontra.index.Result;
import pt.inevo.encontra.index.ResultSet;
import pt.inevo.encontra.lucene.index.LuceneEncontraIndex;
import pt.inevo.encontra.query.KnnQuery;
import pt.inevo.encontra.query.Query;
import pt.inevo.encontra.query.QueryOrder;
import pt.inevo.encontra.query.QueryWeight;
import pt.inevo.encontra.query.RandomQuery;

/**
 * Test the creation of an ImageObject (with the underlying Document from Lucene)
 * @author ricardo
 */
public class TestLuceneEncontraIndex extends TestCase {

    public TestLuceneEncontraIndex(String testName) {
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



    public void testMain() throws FileNotFoundException, IOException {
        String testFilesPath = getClass().getResource("/images").getPath();
        Engine e = new SimpleEngine();
        PersistentIndex<ImageObject> luceneIndex = new LuceneEncontraIndex<ImageObject>("testLuceneIndex",ImageObject.class);  //  TODO - Use File.createTempFile()
        e.registerIndex(luceneIndex);

        if (luceneIndex.load("testLuceneIndex")){
            for (String identifier : getAllImages(new File(testFilesPath), true)) {
                System.out.println("Indexing file " + identifier);
                ImageObject<String> object = new ImageObject<String>();
                object.setId(identifier);
                object.setImage(identifier);
                luceneIndex.insert(object);
            }
            luceneIndex.save("testLuceneIndex");
        }

        String img=getClass().getResource("/images/img01.jpg").getPath();
        ImageObject<String> object = new ImageObject<String>();
        object.setId(img);
        object.setImage(img);
        Query knnQuery = new KnnQuery(object, 10);
        knnQuery.setOrder(new QueryOrder(1));
        knnQuery.setWeight(new QueryWeight(1));

        Query randomQuery = new RandomQuery();

        ResultSet results = e.search(new Query[]{knnQuery, randomQuery});
        System.out.println("Printing the results...");
        for(Result r : results){
            System.out.println("Result id: " + r.getResultObject().getId());
        }
    }
}