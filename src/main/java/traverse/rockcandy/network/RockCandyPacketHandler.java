package traverse.rockcandy.network;

import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;
import traverse.rockcandy.RockCandy;

public class RockCandyPacketHandler {

	public static void setupPackets(final RegisterPayloadHandlerEvent event) {
		final IPayloadRegistrar registrar = event.registrar(RockCandy.MODID);

		registrar.play(AutoFeedPayload.ID, AutoFeedPayload::new, handler -> handler
				.server(AutoFeedPayload::handle));
	}

}
