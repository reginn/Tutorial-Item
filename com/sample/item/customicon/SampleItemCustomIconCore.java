package com.sample.item.customicon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid = "ItemCustomIcon",
	name  = "ItemCustomIcon",
	version = "0.0.0"
)
public class SampleItemCustomIconCore {

	public static Item itemCustomIcon;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * setTextureName("domain名:テクスチャファイル名")で使用するテクスチャを指定する.
		 * domainはbin/minecraft/assets/domain/textures/のようにassets以下のフォルダを指定するもの.
		 * サンプルの場合, 画像ファイルはbin/minecraft/assets/custom/textures/items/circle.pngが参照される.
		 * eclipseでの実行の場合, eclipse/minecraft/bin/assets/custom/textures/items/circle.pngが参照される.
		 * 拡張子(.png)は不要な点に注意
		 */
		itemCustomIcon = (new Item(4002 - 256)).setUnlocalizedName("itemCustomIcon").setTextureName("custom:circle").setCreativeTab(CreativeTabs.tabMaterials);

		LanguageRegistry.addName(itemCustomIcon, "Sample Custom Icon");
	}
}