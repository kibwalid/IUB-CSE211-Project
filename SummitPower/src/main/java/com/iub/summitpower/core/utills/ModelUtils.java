package com.iub.summitpower.core.utills;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ModelUtils {

    public static Map<String, Object> toHashMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        Class<?> convertForm = obj.getClass();
        while (convertForm != null && !convertForm.equals(Object.class)) {
            Field[] fields = convertForm.getDeclaredFields();
            for (Field field : fields) {
                if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    try {
                        map.put(field.getName(), field.get(obj));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            convertForm = convertForm.getSuperclass();
        }
        return map;
    }

    public static <T> T fromHashMap(Map<String, Object> map, Class<T> convertsTo) {
        T obj = null;
        try {
            obj = convertsTo.getDeclaredConstructor().newInstance();
            Class<?> tempConvert = convertsTo;
            while (tempConvert != null && !tempConvert.equals(Object.class)) {
                Field[] fields = tempConvert.getDeclaredFields();
                for (Field field : fields) {
                    if (!java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                        field.setAccessible(true); // to access private fields
                        if (map.containsKey(field.getName())) {
                            field.set(obj, map.get(field.getName()));
                        }
                    }
                }
                tempConvert = tempConvert.getSuperclass();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void validateDouble(String number, String label) {
        try {
            double num = Double.parseDouble(number);
            if(num < 1) {
                ViewControlUtils.showAlert(label + " must be at least 1 Tk");
            }
        } catch (NumberFormatException e) {
            ViewControlUtils.showAlert(label + " number must be a number");
        }
    }


}
