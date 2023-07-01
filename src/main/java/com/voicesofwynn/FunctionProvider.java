package com.voicesofwynn;

import com.voicesofwynn.core.interfaces.IFunctionProvider;
import com.voicesofwynn.core.wrappers.PlayEvent;
import com.voicesofwynn.core.wrappers.VOWLocation;
import com.voicesofwynn.core.wrappers.VOWLocationProvider;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FunctionProvider implements IFunctionProvider {

    @Override
    public void playFileSound(File file, PlayEvent playEvent) {

    }

    @Override
    public VOWLocation getNpcLocationFromName(String s) {
        return null;
    }

    @Override
    public VOWLocation getPlayerLocation() {
        return null;
    }


    @Override
    public Map<String, String[]> defaultSources() {
        return new HashMap<>() {
            {
                put("VoW", new String[] {"https://voicesofwynn.com/files/core-dev-server/vow-src/"});
            }
        };
    }
}
