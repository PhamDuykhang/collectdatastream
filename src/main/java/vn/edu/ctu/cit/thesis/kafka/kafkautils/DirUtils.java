package vn.edu.ctu.cit.thesis.kafka.kafkautils;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class DirUtils {
    public static ArrayList<String> getListFolder(String parentfolder) throws IOException{
        ArrayList<String> cache = new ArrayList<String>();
        Files.walkFileTree(Paths.get(parentfolder.toString()),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                cache.add(dir.toFile().getAbsolutePath());
                return FileVisitResult.CONTINUE;
            }
        });
        cache.remove(cache.size()-1);
        return cache;
    }
    public static ArrayList<String> getListFileName(String folder) throws IOException{
        ArrayList<String> cache = new ArrayList<String>();
        Files.walkFileTree(Paths.get(folder.toString()),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                cache.add(file.toFile().getAbsolutePath());
//                cache.remove()
                return FileVisitResult.CONTINUE;
            }
        });
        return cache;
    }
    public static String getFileNameFormPatch(String fullpath){
        return fullpath.substring(fullpath.lastIndexOf("\\")+1);
    }
    public static String getPathWithoutFilename(String fullpath){
        return fullpath.substring(0,fullpath.lastIndexOf("\\")+1);
    }
    private static void copyFileUsingStream(String source, String dest) throws IOException {
        File sourcef = new File(source);
        File destf = new File(source);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(sourcef);
            os = new FileOutputStream(destf);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } finally {
            is.close();
            os.close();
        }
    }
    public static void moveFile(String source,String dest ){
        Path sourcep= Paths.get(source);
        Path destp = Paths.get(dest);
        try {
            Files.move(sourcep,destp,REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
