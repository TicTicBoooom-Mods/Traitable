package quarris.traitable.mod;

import net.minecraft.commands.Commands;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import quarris.traitable.mod.network.COpenConfigPacket;
import quarris.traitable.mod.network.PacketHandler;
import quarris.traitable.mod.traits.TraitHolder;


@Mod.EventBusSubscriber(modid = ModRef.ID)
public class CommonEvents {

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (Traitable.SETTINGS.hasAttachableTraits(event.getObject())) {
            event.addCapability(ModRef.createRes("trait_holder"), new TraitHolder.Provider(new TraitHolder(event.getObject())));
        }
    }

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("traitable")
                .executes(source -> {
                    source.getSource().sendSuccess(new TextComponent("Opening Traitable Gui!"), false);
                    PacketHandler.sendTo(source.getSource().getPlayerOrException(), new COpenConfigPacket());
                    return 1;
                })
        );
    }

}
