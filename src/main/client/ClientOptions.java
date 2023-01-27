package main.client;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ClientOptions {
    private final Options options;
    private final Option port;
    private final Option host;

    public ClientOptions() {
        options = new Options();
        port = new Option("p" , "port" , true , "server port");
        host = new Option("h" , "host" , true , "host");
        port.setRequired(true);
        host.setRequired(true);
        options.addOption(port);
        options.addOption(host);
    }

    public Options getOptions() {
        return options;
    }
}
