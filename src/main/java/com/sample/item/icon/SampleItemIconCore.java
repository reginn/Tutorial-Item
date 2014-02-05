package com.sample.item.icon;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = SampleItemIconCore.MODID, version = SampleItemIconCore.VERSION)
public class SampleItemIconCore
{
	public static final String MODID   = "ItemIcon";
	public static final String VERSION = "0.0.0";

	public static Item itemIconUsesVanillaTexture;
	public static Item itemIconUsesCustomTexture;
	public static Item itemIconUsesColorMultiplier;
	public static Item itemIconUsesComplexTexture;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		 * setTextureName("テクスチャファイル名")で使用するテクスチャを指定する.
		 * バニラのアイテムのテクスチャ名はItemクラスを参照するか, minecraft.jar内のassets/minecraft/textures/itemsを参照
		 * 拡張子(.png)は不要な点に注意
		 */
		itemIconUsesVanillaTexture = (new Item())
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
		itemIconUsesCustomTexture = (new Item())
				.setUnlocalizedName("itemCustomIcon")
				.setTextureName("icon:circle")
				.setCreativeTab(CreativeTabs.tabMaterials);

		/*
		 * 基本は今までどおり, ItemクラスではなくItemクラスを継承したItemColorクラスからインスタンスを生成する.
		 */
		itemIconUsesColorMultiplier = (new ItemColor())
				.setUnlocalizedName("itemColorIcon")
				.setTextureName("apple")
				.setCreativeTab(CreativeTabs.tabMaterials);

		/*
		 * 基本はいままでどおり, ItemクラスではなくItemクラスを継承したItemComplexクラスからインスタンスを生成する.
		 * 今回はsetTextureNameで指定したテクスチャに, ItemComplex内で追加したテクスチャを重ねている.
		 */
		itemIconUsesComplexTexture = (new ItemComplex())
				.setUnlocalizedName("itemComplexIcon")
				.setTextureName("icon:cross")
				.setCreativeTab(CreativeTabs.tabMaterials);

		GameRegistry.registerItem(itemIconUsesVanillaTexture,  "ItemIcon");
		GameRegistry.registerItem(itemIconUsesCustomTexture,   "ItemCustomIcon");
		GameRegistry.registerItem(itemIconUsesColorMultiplier, "ItemColorIcon");
		GameRegistry.registerItem(itemIconUsesComplexTexture,  "ItemComplexIcon");
	}
}
