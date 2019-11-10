package classes;

import java.io.*;
import java.util.*;

public class SysIO {
    private HashMap<String, User> data;
    private String filePath;

    public SysIO(String filePath) throws Exception {
        this.filePath = filePath;
        data = new HashMap<>();
        BufferedReader in = null;
        // load .txt to system
        String line;
        try {
            in = new BufferedReader(new FileReader(filePath));
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(",");
                User temp = null;
                switch (Integer.parseInt(parts[0])) {
                case 1: // manager
                    temp = new Manager(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5],
                            parts[6]);
                    break;
                case 2: // worker
                    temp = new Client(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5],
                            parts[6]);

                    break;
                case 3: // client
                    temp = new Worker(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5],
                            parts[6]);
                    break;
                }

                this.data.put(parts[1], temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }

    // save hashmap to .txt file
    public void save(HashMap<String, User> data) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(this.filePath));
            for (Map.Entry<String, User> entry : data.entrySet()) {
                out.write(entry.getValue().type + "," + entry.getValue().login + "," + entry.getValue().password + ","
                        + entry.getValue().name + "," + entry.getValue().phone + "," + entry.getValue().email + ","
                        + entry.getValue().address + "\n");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // lastly, close the file and end
        out.close();
    }

    public HashMap<String, User> getData() {
        return this.data;
    }
}