package com.sample.item.color;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid = "ItemColorIcon",
	name  = "ItemColorIcon",
	version = "0.0.0"
)
public class SampleItemColorCore {

	public static Item itemColorIcon;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * 基本は今までどおり, ItemクラスではなくItemクラスを継承したItemColorクラスからインスタンスを生成する.
		 */
		itemColorIcon = (new ItemColor(4003 - 256)).setUnlocalizedName("itemColorIcon").setTextureName("apple").setCreativeTab(CreativeTabs.tabMaterials);

		LanguageRegistry.addName(itemColorIcon, "Sample Color Icon");
	}
}