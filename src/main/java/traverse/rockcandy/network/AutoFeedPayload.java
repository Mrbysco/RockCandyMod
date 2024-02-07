package traverse.rockcandy.network;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import traverse.rockcandy.RockCandy;

public record AutoFeedPayload(boolean enableAutoFeed, int slot) implements CustomPacketPayload {
	public static final ResourceLocation ID = new ResourceLocation(RockCandy.MODID, "auto_feed");

	public AutoFeedPayload(FriendlyByteBuf buff) {
		this(buff.readBoolean(), buff.readInt());
	}

	public void write(FriendlyByteBuf buff) {
		buff.writeBoolean(enableAutoFeed);
		buff.writeInt(slot);
	}

	@Override
	public ResourceLocation id() {
		return ID;
	}

	public static void handle(AutoFeedPayload autoFeed, final PlayPayloadContext context) {
		context.workHandler().submitAsync(() -> {
			context.player().ifPresent(player -> {
				updateAutoFeed(player.getInventory().getItem(autoFeed.slot), autoFeed.enableAutoFeed);
			});
		});
	}

	public static void updateAutoFeed(ItemStack stack, boolean bool) {
		CompoundTag compound = stack.getTag();

		if (compound == null) {
			compound = new CompoundTag();
		}
		compound.putBoolean("autoFeed", bool);
		stack.setTag(compound);
	}
}
