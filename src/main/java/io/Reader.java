package io;

import components.Level;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Reader {

    private static int index;
    private static JSONObject setting;
    private static int[] activeTiles;

    public static Object getSettingsVariable(String variable) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(Reader.class.getResource("/settings.json").getFile())) {
            Object obj = parser.parse(reader);
            JSONArray settingVariables = (JSONArray) obj;

            settingVariables.forEach(e -> {
                setting = (JSONObject) ((JSONObject) e).get("general_settings");
            });
            return setting.get(variable);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static List<Level> getAvailableTileLevels() {
        JSONParser parser = new JSONParser();
        List<Level> tileLevels = new LinkedList<>();

        try (FileReader reader = new FileReader(Reader.class.getResource("/levels.json").getFile())) {
            Object obj = parser.parse(reader);
            JSONArray levels = (JSONArray) obj;

            index = 1;

            levels.forEach(e -> {
                JSONObject level = (JSONObject) ((JSONObject) e).get("level_" + index);

                boolean isEmpty = (((String)level.get("activeTiles")).equalsIgnoreCase("/"));

                if (!isEmpty) {
                    String[] tiles = ((String) level.get("activeTiles")).split("-");
                    activeTiles = new int[tiles.length];
                    for (int i = 0; i < tiles.length; i++) {
                        activeTiles[i] = Integer.parseInt(tiles[i]);
                    }
                }

                tileLevels.add(
                  new Level(
                          index,
                          Integer.parseInt(String.valueOf(level.get("rows"))),
                          Integer.parseInt(String.valueOf(level.get("columns"))),
                          (isEmpty) ? null : activeTiles
                  )
                );
                index++;
            });

            return tileLevels;
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
