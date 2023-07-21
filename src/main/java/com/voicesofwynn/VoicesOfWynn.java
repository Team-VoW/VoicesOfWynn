package com.voicesofwynn;

import com.voicesofwynn.core.VOWCore;
import com.voicesofwynn.core.soundmanager.DefaultSoundManager;
import com.voicesofwynn.core.soundmanager.SoundManager;
import com.voicesofwynn.core.sourcemanager.SourceManager;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class VoicesOfWynn implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("voicesofwynn");

    @Override
    public void onInitialize() {

        new Thread(() -> {
            File enables = new File("VoW/files/sources/VoW/enables.yml");
            if (!enables.exists()) {
                enables.getParentFile().mkdirs();
                try {
                    Files.write(enables.toPath(), ("quests: \"*\"\n" +
                                            "other: \"*\"").getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            VOWCore.init(new FunctionProvider(), new File("VoW"));
            SourceManager.getInstance().update();
            SoundManager.instance = new DefaultSoundManager();
            SoundManager.instance.start();
        }).start();

    }
}