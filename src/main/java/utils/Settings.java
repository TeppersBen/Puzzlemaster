package utils;

import io.Reader;

public class Settings {

    public static int width = Integer.parseInt(String.valueOf(Reader.getSettingsVariable("frame_width")));
    public static int height = Integer.parseInt(String.valueOf(Reader.getSettingsVariable("frame_height")));

}
