package com.iub.summitpower.helpers;

import com.iub.summitpower.core.models.database.BaseEntity;
import com.iub.summitpower.config.Constants;
import com.iub.summitpower.core.models.database.SeniorExecutive;
import com.iub.summitpower.core.utills.ModelUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public abstract class DatabaseHelper<K, V extends BaseEntity> {

    // TODO:: Make sure I throw error whenever there is no element or no element with primary key
    private String databaseFileName = ".txt";
    private File databaseFile;
    private Class<V> entity;

    protected DatabaseHelper(String databaseName, Class<V> entity) {
        this.databaseFileName = databaseName + this.databaseFileName;
        this.databaseFile = new File(Constants.DATABASE_DIRECTORY_PATH, this.databaseFileName);
        if (!databaseExists()) {
            if (createDatabase()) {
                System.out.println("Database file " + this.databaseFileName + " has been created!");
            } else {
                System.out.println("Database file " + this.databaseFileName + " was not created due to a file error!");
            }
        }
        this.entity = entity;
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
                    if(databaseFile.createNewFile()) {
                        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(Constants.DATABASE_DIRECTORY_PATH + "/" + databaseFileName));
                        HashMap<K, V> initial = new HashMap<>();
                        stream.writeObject(initial);
                    }
                    return true;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }
        return false;
    }

    protected boolean add(K key, V value) {
        Map<K, Map<String, Object>> database = readDatabase();
        if (key instanceof Integer) {
            key = (K)generateIntegerKey();
        }
        if (database.containsKey(key)) {
            return false;
        }
        database.put(key, ModelUtils.toHashMap(value));
        return writeDatabase(database);
    }

    private Integer generateIntegerKey() {
        Map<K, Map<String, Object>> database = readDatabase();
        int maxKey = database.keySet().stream()
                .filter(key -> key instanceof Integer)
                .mapToInt(key -> (Integer) key)
                .max()
                .orElse(0);
        return maxKey + 1;
    }

    protected V get(K key) {
        Map<K, Map<String, Object>> database = readDatabase();
        return ModelUtils.fromHashMap(database.get(key), entity);
    }

    protected Map<K, V> getAll() {
        Map<K, Map<String, Object>> database = readDatabase();
        Map<K, V> result = new HashMap<>();
        for (Map.Entry<K, Map<String, Object>> entry : database.entrySet()) {
            V value = ModelUtils.fromHashMap(entry.getValue(), entity);
            result.put(entry.getKey(), value);
        }
        return result;
    }

    protected int count() {
        return readDatabase().size();
    }

    protected boolean update(K key, V newValue) {
        Map<K, Map<String, Object>> database = readDatabase();
        if (!database.containsKey(key)) {
            return false;
        }
        database.put(key, ModelUtils.toHashMap(newValue));
        return writeDatabase(database);
    }

    protected boolean deleteRecord(K key) {
        Map<K, Map<String, Object>> database = readDatabase();
        if (!database.containsKey(key)) {
            return false; // Record with the given key does not exist
        }
        database.remove(key);
        return writeDatabase(database);
    }

    private boolean writeDatabase(Map<K, Map<String, Object>> database) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.DATABASE_DIRECTORY_PATH + "/" + databaseFileName))) {
            oos.writeObject(database);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Map<K, Map<String, Object>> readDatabase() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.DATABASE_DIRECTORY_PATH + "/" + databaseFileName));
            return (Map<K, Map<String, Object>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return new HashMap<>();
    }

}
