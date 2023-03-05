import java.io.*;
import java.net.URL;

public class Get {
    public static void main(String[] args) throws Exception {
        System.out.println(args[0] + " -> " + args[1]);
        InputStream in = new URL(args[0]).openStream();
        OutputStream out = new FileOutputStream(args[1]);
        byte[] buf = new byte[4096];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }
}
