package com.sample.item.weapon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

import net.minecraftforge.common.EnumHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid = "ItemWeapon",
	name  = "ItemWeapon",
	version = "0.0.0"
)
public class SampleItemWeaponCore {

	public static Item itemWeapon;

	public static final EnumToolMaterial BLUE = EnumHelper.addToolMaterial("BLUE", 0, 150, 1.0F, 10.0F, 30);

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * ItemSwordからインスタンスを作成する. 引数のEnumToolMaterialはツール追加のときと同じ.
		 * 武器の攻撃力はToolMaterialで設定した値+4.0Fになる.
		 * クリエイティブタブの武器タブに追加する.
		 */
		itemWeapon = (new ItemSword(10011 - 256, BLUE))
				.setUnlocalizedName("itemWeapon")
				.setTextureName("weapon:blue_sword")
				.setCreativeTab(CreativeTabs.tabCombat);

		LanguageRegistry.addName(itemWeapon, "Sample Item Weapon");
	}
}
