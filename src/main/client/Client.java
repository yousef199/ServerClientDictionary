package main.client;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        ClientOptions clientOptions = new ClientOptions();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            Scanner s = new Scanner(System.in);
            cmd = parser.parse(clientOptions.getOptions() , args);
            Socket socket = new Socket(cmd.getOptionValue("h") , Integer.parseInt(cmd.getOptionValue("p")));
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while(true){
                System.out.println("Enter Word To Search");
                String wordToSearch = s.next();
                dataOutputStream.writeUTF(wordToSearch);
                System.out.println(dataInputStream.readUTF());
            }
        }catch (ParseException parseException){
            System.out.println(parseException.getMessage());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
