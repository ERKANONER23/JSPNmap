package kali;

import java.io.IOException;
import java.io.InputStream;

public class Ncrack {

    public void islem() {
        String sorgu = "ncrack ftp://192.168.0.105";
        String dizi[] = new String[2];
        dizi[0] = "ncrack";
        dizi[1] = "ftp://192.168.0.105";
        
    }

    public static String nmapKonsolIslemleri(String dizi[]) throws IOException {

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(dizi, null);
        InputStream inputStream = process.getInputStream();
        int output = 0;

        String sonuc = "";

        while ((output = inputStream.read()) != -1) {
            System.out.print((char) output);
            if ((char) output == '\n') {
                sonuc += "<br>";
            } else {
                sonuc += (char) output;
            }
        }
        return sonuc;

    }

}
