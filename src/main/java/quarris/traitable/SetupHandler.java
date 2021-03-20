package quarris.traitable;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import quarris.traitable.traits.ITraitHolder;

public class SetupHandler {

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event) {
        ModUtil.registerCapability(ITraitHolder.class);
        System.out.println(TraitRegistry.TRAIT_TYPES.getKeys());
    }

    @SubscribeEvent
    public void clientSetup(FMLClientSetupEvent event) {

    }

}