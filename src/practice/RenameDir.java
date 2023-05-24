package practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class RenameDir {
    static String whatDelete="123";

    public static void main(String[] args) throws Exception {
        Path dir= Paths.get("/Users/user/Documents/rename/");
    }

//
//    public static void renameDirectories(Path dir) throws Exception {
//
//
//        try (Stream<Path> files = Files.list(dir)) {
//            files.map(i->
//            {
//                if (Files.isDirectory(i)) {
//                    DirectoryStream<Path> dirStream = null;
//                    try {
//                        dirStream = Files.newDirectoryStream(i);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                    for (Path file : dirStream) {
//                        try {
//                            renameDirectories(i);
//                        } catch (Exception e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//
//
//                if(i.getFileName().toString().startsWith(whatDelete))
//                {
//                        Files.move(i,i.resolveSibling(dir.getFileName().toString().substring(whatDelete.length())));
//
//                }
//                return;
//            }
//                    );
//        } catch (IOException e) {
//                    System.out.println("Error listing directory files: " + e.getMessage());
//        }
//    }
}