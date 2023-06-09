package com.voicesofwynn.mixin;

import com.voicesofwynn.VOWCommon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ConnectScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConnectScreen.class)
public abstract class MixinServerConnectListener {

    @Inject(method = "connect", at = @At("HEAD"))
    private void onSuccess(Minecraft minecraft, ServerAddress serverAddress, ServerData serverData, CallbackInfo info) {
        String serverIP = serverData.ip;
        VOWCommon.getInstance().getLogger().locLog("[VOW-"+VOWCommon.getInstance().getModLoader().name()+"] Server: " + serverIP);
        if (serverIP.contains(".wynncraft.")) {
            VOWCommon.getInstance().getLogger().locLog("[VOW-"+VOWCommon.getInstance().getModLoader().name()+"] Joined live Wynncraft server");
            VOWCommon.getInstance().setWynnServer(true);
        }
    }

}
