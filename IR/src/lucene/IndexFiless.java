package lucene;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.lang.model.util.Elements;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.w3c.dom.Element;



/** Index all text files under a directory.
 * <p>
 * This is a command-line application demonstrating simple Lucene indexing.
 * Run it with no command-line arguments for usage information.
 */
public class IndexFiless {
 
// id for the page and it's name
public static Map<String, Integer> documentInfo = new HashMap<String, Integer>();
// id of the page and it's urls 
public static Map<Integer, ArrayList<String>> documentlinks = new HashMap<Integer, ArrayList<String>>();
public static int docID = 1;

  private IndexFiless() {}

  /** Index all text files under a directory. 
 * @throws UnsupportedEncodingException 
 * @throws FileNotFoundException */
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    String usage = "java org.apache.lucene.demo.IndexFiles"
                 + " [-index INDEX_PATH] [-docs DOCS_PATH] [-update]\n\n"
                 + "This indexes the documents in DOCS_PATH, creating a Lucene index"
                 + "in INDEX_PATH that can be searched with SearchFiles";
    String indexPath = "C:\\Users\\Student\\Desktop\\MASTERS2\\Info-retreival\\ASST4\\Bm25Index";
    String docsPath = "D:\\Prison Break\\Prison Break Wiki\\prisonbreak.fandom.com";
    boolean create = true;
    for(int i=0;i<args.length;i++) {
      if ("-index".equals(args[i])) {
        indexPath = args[i+1];
        i++;
      } else if ("-docs".equals(args[i])) {
        docsPath = args[i+1];
        i++;
      } else if ("-update".equals(args[i])) {
        create = false;
      }
    }

    if (docsPath == null) {
      System.err.println("Usage: " + usage);
      System.exit(1);
    }

    final Path docDir = Paths.get(docsPath);
    if (!Files.isReadable(docDir)) {
      System.out.println("Document directory '" +docDir.toAbsolutePath()+ "' does not exist or is not readable, please check the path");
      System.exit(1);
    }
    
    Date start = new Date();
    try {
      System.out.println("Indexing to directory '" + indexPath + "'...");

      Directory dir = FSDirectory.open(Paths.get(indexPath));
      EnglishAnalyzer analyzer = new EnglishAnalyzer();
      IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
      
      // Indexing using BM25 model
      //iwc.setSimilarity(new BM25Similarity());
      // using Language model
      //iwc.setSimilarity(new LMDirichletSimilarity());
      iwc.setSimilarity(new ClassicSimilarity());
      
      if (create) {
        // Create a new index in the directory, removing any
        // previously indexed documents:
        iwc.setOpenMode(OpenMode.CREATE);
      } else {
        // Add new documents to an existing index:
        iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
      }

  
      IndexWriter writer = new IndexWriter(dir, iwc);
      indexDocs(writer, docDir);

 
      writer.close();

      Date end = new Date();
      System.out.println(end.getTime() - start.getTime() + " total milliseconds");

    } catch (IOException e) {
      System.out.println(" caught a " + e.getClass() +
       "\n with message: " + e.getMessage());
    }
    
    
//    for (Entry<Integer, ArrayList<String>> entry : documentlinks.entrySet()) {
//    	System.out.println("the name of the document is "+ entry.getKey()+ " and the links are "+ entry.getValue());
//    	
//    }
    
    
    // implementing page rank algorithm
    Map<String, Double> E = new HashMap<String, Double>();
    Map<String, Double> R = new HashMap<String, Double>();
    for (Entry<String, Integer> entry : documentInfo.entrySet()) {
    	E.put(entry.getKey(), 1.0/documentInfo.size());
    	R.put(entry.getKey(), 1.0/documentInfo.size());
    }
    
    double alpha = 0.15;
    for( int i=0;i<12;i++) {
    	System.out.println("Iteration: "+ i);
    	for (Entry<String, Integer> entry : documentInfo.entrySet()) {
    		System.out.println("Page ID: "+ entry.getValue());
    		double sum = 0;
    		for (Entry<String, Integer> innerentry : documentInfo.entrySet()) {
    			ArrayList mylist = documentlinks.get(innerentry.getValue());
    			//System.out.println("my list is "+ mylist);
    			int count = 0;
    			for(int j=0;j<mylist.size();j++) {
    				//System.out.println("hellllllllllo this is entry.getkey "+entry.getKey());
    				//System.out.println("hellllllllllo this is mylistingetj "+mylist.get(j));
    				if(mylist.get(j).equals(entry.getKey()))
    					count++;
    			}
    			if(count!=0)
    				sum+=R.get(innerentry.getKey())/mylist.size();
    		}
    		
    		R.put(entry.getKey(), (1-alpha)* sum + alpha*E.get(entry.getKey()));
    		
        }
    	
    	double sum1 = 0.0;
    	for (Entry<String, Double> entry : R.entrySet()) {
    		sum1+=R.get(entry.getKey());
    	}
    	
    	double c = 1/sum1;
    	//double c = 0.5;
    	for (Entry<String, Integer> entry : documentInfo.entrySet()) {
    		 R.put(entry.getKey(), c*R.get(entry.getKey()));
    	}
    }
    
//    for (Entry<String, Double> entry : R.entrySet()) {
//    	System.out.println("the name of the document is "+ entry.getKey()+ " and the score is "+ entry.getValue());
//    }
    
    final Map<String, Double> sortedByCount = R.entrySet()

            .stream()

            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))

            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    
    int counter=0;
    PrintWriter writerpageranks = new PrintWriter("C:\\Users\\Student\\Desktop\\MASTERS2\\Info-retreival\\ASST5\\allpagesrank.txt", "UTF-8");
    
    for (Entry<String, Double> entry : sortedByCount.entrySet()) {
    	//if(counter==10)
    		///break;
    	writerpageranks.println("the name of the document is "+ entry.getKey()+ " and the score is "+ entry.getValue());
    	//counter++;
    }
    writerpageranks.close();
    
    
    
  }

  
  

  static void indexDocs(final IndexWriter writer, Path path) throws IOException {
    if (Files.isDirectory(path)) {
      Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
          try {
            indexDoc(writer, file, attrs.lastModifiedTime().toMillis());
          } catch (IOException ignore) {
            // don't index files that can't be read.
          }
          docID++;
          return FileVisitResult.CONTINUE;
        }
      });
    } else {
      indexDoc(writer, path, Files.getLastModifiedTime(path).toMillis());
    }
  }

  /** Indexes a single document */
  static void indexDoc(IndexWriter writer, Path file, long lastModified) throws IOException {
	  
    try (InputStream stream = Files.newInputStream(file)) {
      // make a new, empty document
      Document doc = new Document();

      Field pathField = new StringField("path", file.toString(), Field.Store.YES);
      doc.add(pathField);

      doc.add(new LongPoint("modified", lastModified));
      doc.add(new TextField("contents", new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))));
      
      
      String documentName = file + "";
      documentInfo.put(documentName, docID);
      if (writer.getConfig().getOpenMode() == OpenMode.CREATE) {
        // New index, so we just add the document (no old document can be there):
        //System.out.println("adding " + file);
        writer.addDocument(doc);
      } else {
        // Existing index (an old copy of this document may have been indexed) so 
        // we use updateDocument instead to replace the old one matching the exact 
        // path, if present:
        System.out.println("updating " + file);
        writer.updateDocument(new Term("path", file.toString()), doc);
      }
      ArrayList links = new ArrayList();
      // printing the links
      File d = new File(documentName);
      FileReader targetReader2 = new FileReader(d);
      StringBuilder sb = new StringBuilder();
      BufferedReader br = new BufferedReader(targetReader2);
      String line;
      
      while ((line = br.readLine()) != null) {
      String link = null;
      boolean flag = false;
      if (line.contains("href=\"")) {
    	  //System.out.println(line);
      for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) == 'h' && line.charAt(i + 1) == 'r' && line.charAt(i + 2) == 'e'
      && line.charAt(i + 3) == 'f' && line.charAt(i + 4) == '=') {
      flag = true;
      i = i + 6;
      }
      if (flag) {
      if (line.charAt(i) == '"') {
      flag = false;
      break;
      }
      }
      if (flag) {
      link += line.charAt(i);
      }
      if (!flag) {
      link = "";
      }
      
      }
      String endwith = "html";
      if(link.endsWith(endwith)) {
    	  link = "D:\\Prison Break\\Prison Break Wiki\\prisonbreak.fandom.com\\"+ link;
    	  //System.out.println( link);
    	  links.add(link);
    	  
      }
      }
      }// end the document 
      
      documentlinks.put(docID, links);
    }
	  
  }
 
}