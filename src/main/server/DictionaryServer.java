package main.server;

import org.apache.commons.cli.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DictionaryServer {
    private ServerSocket serverSocket;


    public DictionaryServer() {

    }

    public static void main(String[] args) {
        DictionaryServer dictionaryServer = new DictionaryServer();
        ServerOptions serverOptions = new ServerOptions();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(serverOptions.getOptions() , args);
            dictionaryServer.serverSocket = new ServerSocket(Integer.parseInt(cmd.getOptionValue("p")));
            while (true){
                Socket socket = dictionaryServer.serverSocket.accept();
                System.out.println("new connection identified");
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                Thread thread = new ClientHandler(inputStream , outputStream , socket , cmd.getOptionValue("d"));
                thread.start();
            }
        }catch (ParseException parseException){
            System.out.println(parseException.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
