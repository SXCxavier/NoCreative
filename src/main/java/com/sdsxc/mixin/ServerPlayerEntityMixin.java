package com.sdsxc.mixin;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {
    @Inject(method = "changeGameMode",at=@At("head"))
    private void changeGameMode(GameMode gameMode, CallbackInfoReturnable<Boolean> info){
        if(gameMode.isCreative()){
            info.setReturnValue(true);
        }
    }
}
