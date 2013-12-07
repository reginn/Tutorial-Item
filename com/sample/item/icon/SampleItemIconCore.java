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

	public static Item itemIconUsesVannilaTexure;
	public static Item itemIconUsesCustomTexture;
	public static Item itemIconUsesColorMultiplier;
	public static Item itemIconUsesComplexTexture;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * setTextureName("テクスチャファイル名")で使用するテクスチャを指定する.
		 * バニラのアイテムのテクスチャ名はItemクラスを参照するか, minecraft.jar内のassets/minecraft/textures/itemsを参照
		 * 拡張子(.png)は不要な点に注意
		 */
		itemIconUsesVannilaTexure = (new Item(10001 - 256))
				.setUnlocalizedName("itemIcon")
				.setTextureName("apple")
				.setCreativeTab(CreativeTabs.tabMaterials);

		/*
		 * setTextureName("domain名:テクスチャファイル名")で使用するテクスチャを指定する.
		 * domainはbin/minecraft/assets/domain/textures/のようにassets以下のフォルダを指定するもの.
		 * サンプルの場合, 画像ファイルはbin/minecraft/assets/custom/textures/items/circle.pngが参照される.
		 * eclipseでの実行の場合, eclipse/minecraft/bin/assets/custom/textures/items/circle.pngが参照される.
		 * 拡張子(.png)は不要な点に注意
		 */
		itemIconUsesCustomTexture = (new Item(10002 - 256))
				.setUnlocalizedName("itemCustomIcon")
				.setTextureName("icon:circle")
				.setCreativeTab(CreativeTabs.tabMaterials);

		/*
		 * 基本は今までどおり, ItemクラスではなくItemクラスを継承したItemColorクラスからインスタンスを生成する.
		 */
		itemIconUsesColorMultiplier = (new ItemColor(10003 - 256))
				.setUnlocalizedName("itemColorIcon")
				.setTextureName("apple")
				.setCreativeTab(CreativeTabs.tabMaterials);

		/*
		 * 基本はいままでどおり, ItemクラスではなくItemクラスを継承したItemComplexクラスからインスタンスを生成する.
		 * 今回はsetTextureNameで指定したテクスチャに, ItemComplex内で追加したテクスチャを重ねている.
		 */
		itemIconUsesComplexTexture = (new ItemComplex(10004 - 256))
				.setUnlocalizedName("itemComplexIcon")
				.setTextureName("icon:cross")
				.setCreativeTab(CreativeTabs.tabMaterials);

		LanguageRegistry.addName(itemIconUsesVannilaTexure,   "Sample Icon");
		LanguageRegistry.addName(itemIconUsesCustomTexture,   "Sample Custom Icon");
		LanguageRegistry.addName(itemIconUsesColorMultiplier, "Sample Color Icon");
		LanguageRegistry.addName(itemIconUsesComplexTexture,  "Sample Complex Icon");
	}
}
