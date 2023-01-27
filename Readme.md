# A Simple Multithread Dictionary Server

### Description

This project is to use a client-server architecture, design and implement a multi-threaded server that allows concurrent clients to search the meaning(s) of a word.

Sockets and threads are the lowest level of abstraction for network communication and concurrency.


### Architecture

* The system will follow a client-server architecture in which multiple clients can connect to a (single) multi-threaded server and perform operations concurrently.

* The multi-threaded server implements a thread-per-connection architecture. Meaning each new client connection will spin-up a new thread

### Interaction

* All communication will take place via sockets based on TCP.

* The dictionary entry formats are implemented in JSON.

### Functional Requirements

* Query the meaning(s) of a given word

### Run .jar

All dictionaries are under the dictionaries file. you can add any new dictionary in json format.

To run the GUI, these commands must be typed in terminal:


```
java -jar Server.jar -p <port> -f <dictionary-file>

java -jar Client.jar -p <port> -h <host>
```

### Example

```
java -jar Server.jar -p 8080 -f dictionary.json

java -jar Client.jar -p 8080 -h localhost
```
