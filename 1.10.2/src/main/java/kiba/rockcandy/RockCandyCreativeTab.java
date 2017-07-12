package kiba.rockcandy;

import kiba.rockcandy.registry.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RockCandyCreativeTab extends CreativeTabs {
    public RockCandyCreativeTab(){
        super(RockCandy.MODID);
    }
    @Override
    public Item getTabIconItem() {
        return ModItems.itemRockCandy;

    }
}
