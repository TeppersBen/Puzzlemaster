package io;

import components.TileLevel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Reader {

    private static int index = 1;

    public static List<TileLevel> getAvailableTileLevels() {
        JSONParser parser = new JSONParser();
        List<TileLevel> tileLevels = new LinkedList<>();

        try (FileReader reader = new FileReader(Reader.class.getResource("/levels.json").getFile())) {
            Object obj = parser.parse(reader);
            JSONArray levels = (JSONArray) obj;

            levels.forEach(e -> {
                JSONObject level = (JSONObject) ((JSONObject) e).get("level_" + index);

                String[] tiles = ((String)level.get("activeTiles")).split("-");
                int[] activeTiles = new int[tiles.length];
                for (int i = 0; i < tiles.length; i++) {
                    activeTiles[i] = Integer.parseInt(tiles[i]);
                }

                tileLevels.add(
                  new TileLevel(
                          index,
                          Integer.parseInt(String.valueOf(level.get("rows"))),
                          Integer.parseInt(String.valueOf(level.get("columns"))),
                          activeTiles
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
