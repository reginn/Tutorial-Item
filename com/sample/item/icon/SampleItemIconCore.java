package com.sample.item.icon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid = "ItemIcon",
	name  = "ItemIcon",
	version = "0.0.0"
)
public class SampleItemIconCore {

	public static Item itemIcon;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * setTextureName("テクスチャファイル名")で使用するテクスチャを指定する.
		 * バニラのアイテムのテクスチャ名はItemクラスを参照するか, minecraft.jar内のassets/minecraft/textures/itemsを参照
		 * 拡張子(.png)は不要な点に注意
		 */
		itemIcon = (new Item(4001 - 256)).setUnlocalizedName("itemIcon").setTextureName("apple").setCreativeTab(CreativeTabs.tabMaterials);

		LanguageRegistry.addName(itemIcon, "Sample Icon");
	}
}
