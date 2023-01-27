package main.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private final Socket socket;
    private final MapDictionaryFile mapDictionaryFile;

    public ClientHandler(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Socket socket , String fileName) {
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
        this.socket = socket;
        mapDictionaryFile = new MapDictionaryFile();
        mapDictionaryFile.initializeMap(fileName);
    }

    @Override
    public void run() {
        String wordToSearch;
        String meaning;
        while(true){
            try {
                wordToSearch = dataInputStream.readUTF();
                meaning = mapDictionaryFile.getDictionary().get(wordToSearch);
                if (meaning == null){
                    dataOutputStream.writeUTF("nothing found");
                }else dataOutputStream.writeUTF(meaning);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
