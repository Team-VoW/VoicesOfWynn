package com.voicesofwynn;

import com.voicesofwynn.core.interfaces.IFunctionProvider;
import com.voicesofwynn.core.wrappers.PlayEvent;
import com.voicesofwynn.core.wrappers.VOWLocation;
import com.voicesofwynn.core.wrappers.VOWLocationProvider;

import java.io.File;

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
}
