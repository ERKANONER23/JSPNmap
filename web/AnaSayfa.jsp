
<%@page import="kali.Nmap"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bilgisayar sistemleri lab </h1>
        <h1>Deney 2</h1>

        <form action="AnaSayfa.jsp">

            <input type="text" name="ip" value="IP adresini giriniz"/>
            <input type="text" name="port" value="port numarasını giriniz"/>

            <select name="secim">
                <option>ping</option>
                <option>tcp</option>
                <option>udp</option>
                <option>udp port</option>
            </select>

            <input type="submit" value="tarama başlat " name="gonder"/>

        </form>

    </body>
</html>


<%
    String gonder = request.getParameter("gonder");
    String mesaj = "";
    if (gonder == null) {
        mesaj = "Bilgileri giriniz";
    } else {

        String ip = request.getParameter("ip");
        String secim = request.getParameter("secim");

        String sonuc = "sonuc bulunamadı";

        switch (secim) {
            case "ping":
                sonuc = Nmap.pingSweep(ip);
                break;
            case "tcp":
                sonuc = Nmap.tcpFull(ip);
                break;
            case "udp":
                sonuc = Nmap.pingSweep(ip);
                break;
            case "vv":
                break;
            case "udp port":
                break;
        }
        out.print(sonuc);

    }
    out.print(mesaj);

%>
