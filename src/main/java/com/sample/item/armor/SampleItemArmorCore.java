package com.sample.item.armor;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = SampleItemArmorCore.MODID, version = SampleItemArmorCore.VERSION)
public class SampleItemArmorCore
{
	public static final String MODID = "ItemArmor";
	public static final String VERSION = "0.0.0";

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
	public static final ItemArmor.ArmorMaterial GREEN = EnumHelper.addArmorMaterial("GREEN", 10, new int[]{1, 3, 2, 1}, 10);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
    {
		/*
		 * ItemArmorを継承したItemSampleArmorクラスからインスタンスを生成する.
		 * ItemSampleArmorの引数は(ItemID, EnumArmorMaterial, 防具の種類).
		 */
		itemGreenHelmet = (new ItemSampleArmor(GREEN, HELMET))
				.setUnlocalizedName("itemGreenArmor")
				.setTextureName("armor:green_helmet");

		itemGreenPlate = (new ItemSampleArmor(GREEN, PLATE))
				.setUnlocalizedName("itemGreenPlate")
				.setTextureName("armor:green_plate");

		itemGreenLeggings = (new ItemSampleArmor(GREEN, LEGGINGS))
				.setUnlocalizedName("itemGreenLeggings")
				.setTextureName("armor:green_leggings");

		itemGreenBoots = (new ItemSampleArmor(GREEN, BOOTS))
				.setUnlocalizedName("itemGreenBoots")
				.setTextureName("armor:green_boots");

		GameRegistry.registerItem(itemGreenHelmet,   "ItemGreenHelmet");
		GameRegistry.registerItem(itemGreenPlate,    "ItemGreenPlate");
		GameRegistry.registerItem(itemGreenLeggings, "ItemGreenLeggings");
		GameRegistry.registerItem(itemGreenBoots,    "ItemGreenBoots");
	}
}
