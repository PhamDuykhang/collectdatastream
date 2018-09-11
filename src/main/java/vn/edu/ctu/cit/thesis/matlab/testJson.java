package vn.edu.ctu.cit.thesis.matlab;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class testJson {
    public static void main(String[] args) {
        Gson gson = new Gson();
        JsonObject obj = new JsonObject();
        obj.addProperty("cameraId","12");
        obj.addProperty("rows", 14);
        obj.addProperty("cols", 22);
        obj.addProperty("type", "b213");
        String json = gson.toJson(obj);
        System.out.println(json);
    }
}
