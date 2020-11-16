import java.util.*;
import java.io.*;

public class HandleInputData  {
    public static Double[] handleInput(String args) throws IOException {
        final String path = args;
        String text = "";
        String newLine = "";
        final BufferedReader reader = new BufferedReader(new FileReader(path));
        for (int i = 0; i < 5; i++) {
            reader.readLine();
        }
        while (((text = reader.readLine()) != null) && !Objects.equals(text, "EOF")) {
            text = text.trim();
            if (text.length() != 0)
                newLine += (text + "_");
        }
        reader.close();
        newLine = newLine.replaceAll("\\s+", "_");
        String[] ary = newLine.split("_");
        final Double[] distarray = new Double[ary.length];

        for (int i = 0; i < ary.length; i++) {
            distarray[i] = Double.parseDouble(ary[i]);
        }
        ary = null;
        return distarray;
    }
}
