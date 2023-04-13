package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compressor {
    public static void method (File file) throws IOException{
        String fileDirectory = file.getParent();
        FileInputStream file_input = new FileInputStream(file);
        FileOutputStream file_output = new FileOutputStream(fileDirectory+"/compressedFile.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(file_output);
        byte[] buffer = new byte[1024];
        int len ;
        while((len = file_input.read(buffer)) != -1 ){
            gzip.write(buffer,0,len);

        }
        gzip.close();
        file_input.close();
        file_output.close();
    }

    public static void main(String[] args) throws IOException {
        File path = new File("Users/Ayush Singh/Desktop/Data_Compressor/Test File");
        method(path);
    }
}
