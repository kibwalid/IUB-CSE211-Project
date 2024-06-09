package com.iub.summitpower.helpers;

import com.iub.summitpower.core.models.database.BaseEntity;
import config.Constants;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

abstract class DatabaseHelper<K, V extends BaseEntity> {

    private String databaseFileName = ".txt";
    private File databaseFile;

    DatabaseHelper(String databaseName) {
        this.databaseFileName = databaseName + this.databaseFileName;
        this.databaseFile = new File(Constants.DATABASE_DIRECTORY_PATH, this.databaseFileName);
        if (!databaseExists()) {
            if (createDatabase()) {
                System.out.println("Database file " + this.databaseFileName + " has been created!");
            } else {
                System.out.println("Database file " + this.databaseFileName + " was not created due to a file error!");
            }
        }
    }

    private boolean databaseExists() {
        File directory = new File(Constants.DATABASE_DIRECTORY_PATH);
        return directory.exists() && databaseFile.exists();
    }

    private boolean createDatabase() {
        File directory = new File(Constants.DATABASE_DIRECTORY_PATH);
        if (!directory.exists()) {
            if(directory.mkdirs()) {
                try {
                    return databaseFile.createNewFile();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }
        return false;
    }

    protected boolean add(K key, V value) {
        Map<K, V> database = readDatabase();
        if (key instanceof Integer) {
            key = (K)generateIntegerKey();
        }
        if (database.containsKey(key)) {
            return false;
        }
        database.put(key, value);
        return writeDatabase(database);
    }

    private Integer generateIntegerKey() {
        Map<K, V> database = readDatabase();
        int maxKey = database.keySet().stream()
                .filter(key -> key instanceof Integer)
                .mapToInt(key -> (Integer) key)
                .max()
                .orElse(0);
        return maxKey + 1;
    }

    protected V get(K key) {
        Map<K, V> database = readDatabase();
        return database.get(key);
    }

    protected Map<K, V> getAll() {
        return readDatabase();
    }

    protected boolean update(K key, V newValue) {
        Map<K, V> database = readDatabase();
        if (!database.containsKey(key)) {
            return false;
        }
        database.put(key, newValue);
        return writeDatabase(database);
    }

    protected boolean deleteRecord(K key) {
        Map<K, V> database = readDatabase();
        if (!database.containsKey(key)) {
            return false; // Record with the given key does not exist
        }
        database.remove(key);
        return writeDatabase(database);
    }

    private boolean writeDatabase(Map<K, V> database) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(databaseFileName))) {
            oos.writeObject(database);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private Map<K, V> readDatabase() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(databaseFileName));
            return (Map<K, V>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return new HashMap<K, V>();
    }

}