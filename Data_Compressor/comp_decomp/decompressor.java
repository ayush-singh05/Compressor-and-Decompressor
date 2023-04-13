package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();

        FileInputStream file_input = new FileInputStream(file);
        GZIPInputStream gzip = new GZIPInputStream(file_input);
        FileOutputStream file_output = new FileOutputStream(fileDirectory+"/DecompressedFile");

        byte[] buffer = new byte[1024];
        int len;
        while((len =gzip.read(buffer))!= -1) {
            file_output.write(buffer,0,len);
        }
        gzip.close();
        file_input.close();
        file_output.close();

    }

    public static void main(String[] args) throws IOException {
        File path = new File("");
        method(path);
    }
}
