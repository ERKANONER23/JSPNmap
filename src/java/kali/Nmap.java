package kali;

import java.io.IOException;
import java.io.InputStream;

public class Nmap {

    public static String pingSweep(String IP) throws IOException {
        String dizi[] = new String[3];
        dizi[0] = "nmap";
        dizi[1] = "-sP";
        dizi[2] = IP + "/24";
        return nmapKonsolIslemleri(dizi);
    }

    public static String tcpFull(String IP) throws IOException {
        String dizi[] = new String[3];
        dizi[0] = "nmap";
        dizi[1] = "-sT";
        dizi[2] = IP + "/24";
        return nmapKonsolIslemleri(dizi);
    }

    public static String udpFull(String IP) throws IOException {
        String dizi[] = new String[3];
        dizi[0] = "nmap";
        dizi[1] = "-sU";
        dizi[2] = IP + "/24";
        return nmapKonsolIslemleri(dizi);
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
