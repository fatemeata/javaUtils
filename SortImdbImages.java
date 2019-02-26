package sortimdbimages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SortImdbImages {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        searchInFolder();             
    }
    public static void searchInFolder() throws IOException{
        String folderName = "E:\\atayi\\downloads\\imdb_5"; // Give your folderName
        File[] listFiles = new File(folderName).listFiles();
        for(File f : listFiles){
            //System.out.println(f.getAbsoluteFile());
            File[] sublistFiles = f.listFiles();
            for (int i = 0; i < sublistFiles.length; i++) {
                if (sublistFiles[i].isFile()) {
                    String fileName = sublistFiles[i].getName();
                    //System.out.println(sublistFiles[i].getAbsolutePath());
                    String[] name = fileName.split("_"); //get name of file
                    //System.out.println(name[0]);
                    String myfileName = folderName + "\\" + f.getName() + "\\" + name[0];
                    //System.out.println(myfileName);
                    Path path = Paths.get(myfileName);
                    //System.out.println(path);
                    if (!Files.exists(path)) {
                        Files.createDirectory(path); //create directory that named with pic's id
                        //System.out.println("Directory created");
                    } 
                    if (fileName.startsWith(name[0])) {
                        Path sourceDirectory = Paths.get(sublistFiles[i].getAbsolutePath());
                        System.out.println("source: " + sourceDirectory);
                        Path targetDirectory = Paths.get(folderName + "\\" + f.getName() + "\\" + name[0]+ "\\" + sublistFiles[i].getName());
                        System.out.println("target: " + targetDirectory);
                        //copy source to target using Files Class
                        Files.copy(sourceDirectory, targetDirectory);
                    }
                }
            }
        }
    }
}
