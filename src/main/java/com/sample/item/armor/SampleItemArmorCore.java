package com.sample.item.armor;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;

import net.minecraftforge.common.EnumHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid = "ItemArmor",
	name  = "ItemArmor",
	version = "0.0.0"
)
public class SampleItemArmorCore {

	public static Item itemGreenHelmet;
	public static Item itemGreenPlate;
	public static Item itemGreenLeggings;
	public static Item itemGreenBoots;

	public static final int HELMET   = 0;
	public static final int PLATE    = 1;
	public static final int LEGGINGS = 2;
	public static final int BOOTS    = 3;

	/*
	 * 防具のMaterialもToolMaterialと同様になっている.
	 * 引数は(耐久性, 防御性能(int配列), エンチャント補正)
	 * 以下はバニラの防具のMaterial.
	 *   CLOTH( 5, new int[]{1, 3, 2, 1}, 15),
	 *   CHAIN(15, new int[]{2, 5, 4, 1}, 12),
	 *    IRON(15, new int[]{2, 6, 5, 2},  9),
	 *    GOLD( 7, new int[]{2, 5, 3, 1}, 25),
	 * DIAMOND(33, new int[]{3, 8, 6, 3}, 10);
	 */
	public static final EnumArmorMaterial GREEN = EnumHelper.addArmorMaterial("GREEN", 10, new int[]{1, 3, 2, 1}, 10);

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		/*
		 * ItemArmorを継承したItemSampleArmorクラスからインスタンスを生成する.
		 * ItemSampleArmorの引数は(ItemID, EnumArmorMaterial, 防具の種類).
		 */
		itemGreenHelmet = (new ItemSampleArmor(10012 - 256, GREEN, HELMET))
				.setUnlocalizedName("itemGreenArmor")
				.setTextureName("armor:green_helmet");

		itemGreenPlate = (new ItemSampleArmor(10013 - 256, GREEN, PLATE))
				.setUnlocalizedName("itemGreenPlate")
				.setTextureName("armor:green_plate");

		itemGreenLeggings = (new ItemSampleArmor(10014 - 256, GREEN, LEGGINGS))
				.setUnlocalizedName("itemGreenLeggins")
				.setTextureName("armor:green_leggings");

		itemGreenBoots = (new ItemSampleArmor(10015 - 256, GREEN, BOOTS))
				.setUnlocalizedName("itemGreenBoots")
				.setTextureName("armor:green_boots");

		LanguageRegistry.addName(itemGreenHelmet,  "Sample Green Helmet");
		LanguageRegistry.addName(itemGreenPlate,   "Sample Green Plate");
		LanguageRegistry.addName(itemGreenLeggings, "Sample Green Leggings");
		LanguageRegistry.addName(itemGreenBoots,   "Sample Green Boots");
	}
}
