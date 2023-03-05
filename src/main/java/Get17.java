public class Get17 {
    public static void main(String[] args) throws Exception {
        System.out.println(args[0] + " -> " + args[1]);
        try (var in = new java.net.URL(args[0]).openStream();
             var out = new java.io.FileOutputStream(args[1])) {
            in.transferTo(out);
        }
    }
}
