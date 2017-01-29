package com.company.util;

        import com.company.Game;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.PrintWriter;
        import java.net.Socket;
        import java.net.UnknownHostException;
/**
 *
 *
 * Klasa klient- funkcje laczace z serwerem oraz do wymiany informacjami
 *
 */
public class Client {

    public Client() {
    }

    /**
     * ustawienie wartosci typu int otrzymanej od serwera
     * @param ip- numer ip serwera
     * @param port- port na ktorym robimy polaczenie
     * @param protocol-polecenie
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    public static int setInt(String ip, String port,
                             String protocol) throws NumberFormatException, IOException {
        String temp = connection(protocol, ip, port);
        int value;

        value = Integer.parseInt(temp);
        return value;
    }
    /**
     * ustawienie wartosci typu string otrzymanej od serwera
     * @param ip- numer ip serwera
     * @param port- port na ktorym robimy polaczenie
     * @param protocol-polecenie
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    public static String setString (String ip, String port,
                                    String protocol) throws NumberFormatException, IOException {
        String temp= connection(protocol, ip, port);

        return temp;
    }
    /**
     * wyslanie polecenia checi otrzymania listy wynikow
     * @param ip- numer ip serwera
     * @param port- port na ktorym robimy polaczenie
     * @return
     */
    public static String[] getHighScores(String ip, String port) {
        String[] answer;
        try {
            answer = connectionForScores(Protocol.GETHIGHSCORES, ip, port);
        } catch (NumberFormatException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
        return answer;
    }
    /**
     * wyslanie swojego wyniku
     * @param name-nick gracza
     * @param score-uzyskany wynik
     */
    public static void sendScore(String name, int score) {

        Socket socket;
        try {
            socket = new Socket(ServerConector.ip, Integer.parseInt(ServerConector.port));
            socket.setSoTimeout(3000);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            pw.println(Protocol.SENDINGSCORE);
            pw.println(name);
            pw.println(Integer.toString(score));
        } catch (UnknownHostException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * pobranie wiadomoci z serwera
     * @param command
     * @param ip
     * @param port
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    private static String connection(String command, String ip, String port)
            throws NumberFormatException, IOException {

        Socket socket = new Socket(ip, Integer.parseInt(port));
        socket.setSoTimeout(3000);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        pw.println(command);

        switch (command) {

            case Protocol.GETZYCIA: {
                return getLines(br, socket);
            }

            case Protocol.GETSPEED: {
                pw.println(Game.difficultyLvl);
                return getLines(br, socket);
            }

            case Protocol.GETPLANSZAKLOCKOW: {
                pw.println(Game.getGame().getCourse().getLevelNumber());
                return getLines(br, socket);
            }
            default: {
                socket.close();
                throw new IOException("unknown command");
            }
        }

    }


    /**
     * połšczenie dla odebrania tabeli
     * @param command
     * @param ip
     * @param port
     * @return
     * @throws NumberFormatException
     * @throws IOException
     */
    private static String[] connectionForScores(String command, String ip, String port)
            throws NumberFormatException, IOException {

        Socket socket = new Socket(ip, Integer.parseInt(port));
        socket.setSoTimeout(3000);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os, true);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        pw.println(command);

        switch (command) {

            case Protocol.GETHIGHSCORES: {
                return getLinesForScores(20, br, socket);
            }
            default: {
                socket.close();
                throw new IOException("unknown command");
            }
        }

    }
    /**
     * pobranie lini wiadomosci od serwera
     * @param br
     * @param socket
     * @return
     * @throws IOException
     */
    private static String getLines( BufferedReader br, Socket socket)
            throws IOException {
        String answer = new String();
        {
            answer = br.readLine();
            if (answer.equals(Protocol.ERROR))
                throw new IOException("server error");
        }
        socket.close();
        return answer;
    }

    /**
     * czytanie wynikow- pobranie linii wiadomosci od serwera
     * @param count
     * @param br
     * @param socket
     * @return
     * @throws IOException
     */
    private static String[] getLinesForScores(int count, BufferedReader br, Socket socket)
            throws IOException {
        String[] answer = new String[count];
        for (int i = 0; i < count; i++) {
            answer[i] = br.readLine();
            if (answer[i].equals(Protocol.ERROR))
                throw new IOException("server error");
        }
        socket.close();
        return answer;
    }

}
