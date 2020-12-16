package adris.altoclef.mixins;

import adris.altoclef.AltoClef;
import adris.altoclef.Debug;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class EntryMixin {

    private static boolean _initialized = false;

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        if (!_initialized) {
            _initialized = true;
            Debug.logMessage("Global Init");
            AltoClef.getInstance().onInitializeLoad();
        }
    }
}

