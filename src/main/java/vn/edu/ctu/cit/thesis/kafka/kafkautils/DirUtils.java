package vn.edu.ctu.cit.thesis.kafka.kafkautils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

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
}
