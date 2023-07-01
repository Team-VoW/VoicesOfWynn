package com.voicesofwynn;

import com.voicesofwynn.core.VOWCore;
import com.voicesofwynn.core.soundmanager.DefaultSoundManager;
import com.voicesofwynn.core.soundmanager.SoundManager;
import com.voicesofwynn.core.sourcemanager.SourceManager;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class VoicesOfWynn implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("voicesofwynn");

    @Override
    public void onInitialize() {

        new Thread(() -> {
            VOWCore.init(new FunctionProvider(), new File("Voices_of_Wynn"));
            SourceManager.getInstance().update();
            SoundManager.instance = new DefaultSoundManager();
            SoundManager.instance.start();
        }).start();

    }
}