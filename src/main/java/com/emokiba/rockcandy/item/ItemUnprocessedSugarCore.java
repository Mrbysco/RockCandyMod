package com.emokiba.rockcandy.item;

import com.emokiba.rockcandy.creativetab.CreativeTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemUnprocessedSugarCore extends Item
{
    public ItemUnprocessedSugarCore()
    {
        super();
        this.setMaxStackSize(1);
        this.setTextureName("rockcandy:unprocessedsugarCore");
        this.setCreativeTab(CreativeTab.ROCKCANDY_TAB);
        this.setUnlocalizedName("unprocessedsugarCore");

    }
}
