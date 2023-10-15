package nl.teamdiopside.convenientscaffolding;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;

public class Config {
    private static final File configFile = new File("./config/convenient_scaffolding.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static Config INSTANCE = load();

    public static final int MAX_SCAFFOLDING_DISTANCE_DEFAULT = 15;
    public static final double MAX_SCAFFOLDING_FALL_SPEED_DEFAULT = 100;
    public static final double SCAFFOLDING_CLIMB_SPEED_DEFAULT = 0.5;

    public int maxScaffoldingDistance = 15;
    public double maxScaffoldingFallSpeed = 100;
    public double scaffoldingClimbSpeed = 0.5;

    public static void save() {
        if (INSTANCE == null) return;
        try {
            String json = GSON.toJson(INSTANCE);
            FileUtils.write(configFile, json, (Charset) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Config load() {
        if (!configFile.exists()) return new Config();
        try {
            String json = FileUtils.readFileToString(configFile, (Charset) null);
            return GSON.fromJson(json, Config.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new Config();
        }
    }
}
