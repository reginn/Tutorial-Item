package com.sample.item.weapon;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = SampleItemWeaponCore.MODID, version = SampleItemWeaponCore.VERSION)
public class SampleItemWeaponCore
{
	public static final String MODID   = "ItemWeapon";
	public static final String VERSION = "0.0.0";

	public static Item itemWeapon;

	public static final Item.ToolMaterial BLUE = EnumHelper.addToolMaterial("BLUE", 0, 150, 1.0F, 10.0F, 30);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		 * ItemSwordからインスタンスを作成する. 引数のEnumToolMaterialはツール追加のときと同じ.
		 * 武器の攻撃力はToolMaterialで設定した値+4.0Fになる.
		 * クリエイティブタブの武器タブに追加する.
		 */
		itemWeapon = (new ItemSword(BLUE))
				.setUnlocalizedName("itemWeapon")
				.setTextureName("weapon:blue_sword")
				.setCreativeTab(CreativeTabs.tabCombat);

		GameRegistry.registerItem(itemWeapon, "ItemWeapon");
	}
}
