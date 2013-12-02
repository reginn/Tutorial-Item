package com.sample.item.complex;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid = "ItemComplexIcon",
	name  = "ItemComplexIcon",
	version = "0.0.0"
)
public class SampleItemComplexCore {

	public static Item itemComplexIcon;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * 基本はいままでどおり, ItemクラスではなくItemクラスを継承したItemComplexクラスからインスタンスを生成する.
		 * ItemクラスのIconを使わないのでsetTextureNameはしない.
		 */
		itemComplexIcon = (new ItemComplex(4004 - 256)).setUnlocalizedName("itemComplexIcon").setCreativeTab(CreativeTabs.tabMaterials);

		LanguageRegistry.addName(itemComplexIcon, "Item Complex Icon");
	}
}
