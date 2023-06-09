package com.voicesofwynn;

import com.voicesofwynn.core.VOWThread;
import net.minecraft.client.Minecraft;
import org.slf4j.LoggerFactory;

import java.io.File;

public class VOWCommon {

    public static final String MOD_ID = "voicesofwynn";

    private static final VOWCommon instance = new VOWCommon();

    private boolean wynnServer = false;

    private File folderMod;
    private CoreLogger logger;
    private ModLoader modLoader;

    public void enable(ModLoader modLoader) {
        this.folderMod = new File(Minecraft.getInstance().gameDirectory, MOD_ID);
        this.logger = new CoreLogger(LoggerFactory.getLogger(MOD_ID));
        this.modLoader = modLoader;

        new VOWThread(folderMod, modLoader, logger).start();

        logger.locLog("[VOW-"+modLoader.name()+"] Init version Alpha-0.0.3 (MC: 1.19.4)");
    }

    public File getFolderMod() {
        return folderMod;
    }

    public CoreLogger getLogger() {
        return logger;
    }

    public boolean isWynnServer() {
        return wynnServer;
    }

    public void setWynnServer(boolean wynnServer) {
        this.wynnServer = wynnServer;
    }

    public ModLoader getModLoader() {
        return modLoader;
    }

    public static VOWCommon getInstance() {
        return instance;
    }

    public enum ModLoader {
        FORGE, FABRIC
    }
}