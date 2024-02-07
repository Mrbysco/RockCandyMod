package traverse.rockcandy;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import traverse.rockcandy.client.ClientHandler;
import traverse.rockcandy.network.RockCandyPacketHandler;
import traverse.rockcandy.registry.ConfigHandler;
import traverse.rockcandy.registry.ModBlocks;
import traverse.rockcandy.registry.ModItems;
import traverse.rockcandy.registry.ModTabs;

import java.io.File;

@Mod(RockCandy.MODID)
public class RockCandy {
	public static final String MODID = "rockcandy";
	public static final Logger LOGGER = LogManager.getLogger();

	public RockCandy(IEventBus eventBus) {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.configSpec);

		eventBus.addListener(RockCandyPacketHandler::setupPackets);

		ModBlocks.BLOCKS.register(eventBus);
		ModItems.ITEMS.register(eventBus);
		ModTabs.CREATIVE_MODE_TABS.register(eventBus);

		if (FMLEnvironment.dist.isClient()) {
			eventBus.addListener(ClientHandler::onRegisterKeyMappings);
		}
	}
}

