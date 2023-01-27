package main.server;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ServerOptions {
    private final Options options;
    private final Option port;
    private final Option dictionaryName;

    public ServerOptions() {
        options = new Options();
        port = new Option("p" , "port" , true , "server port");
        dictionaryName = new Option("d" , "dictionary" , true , "dicrionary file");
        port.setRequired(true);
        dictionaryName.setRequired(true);
        options.addOption(port);
        options.addOption(dictionaryName);
    }

    public Options getOptions() {
        return options;
    }
}
