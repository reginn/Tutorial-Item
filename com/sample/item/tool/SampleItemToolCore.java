package com.sample.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

import net.minecraftforge.common.EnumHelper;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
	modid = "ItemTool",
	name  = "ItemTo0l",
	version = "0.0.0"
)
public class SampleItemToolCore {

	public static Item itemRedShovel;
	public static Item itemRedAxe;
	public static Item itemRedPickaxe;
	public static Item itemRedHoe;

	/*
	 * 新しいToolMaterialを追加するAPI
	 * 引数は(Materia名, 採掘レベル, 採掘速度, Entityに対するダメージ, エンチャント補正
	 * 以下はバニラのツールの数値
	 *    WOOD(0,   59,  2.0F, 0.0F, 15) : 木ツール
	 *   STONE(1,  131,  4.0F, 1.0F,  5) : 石ツール
	 *    IRON(2,  250,  6.0F, 2.0F, 14) : 鉄ツール
	 * EMERALD(3, 1561,  8.0F, 3.0F, 10) : ダイアツール
	 *    GOLD(0,   32, 12.0F, 0.0F, 22) : 金ツール
	 *
	 * 今回は鉄ツールと同じ採掘レベル(黒曜石だけ掘れない), 耐久は100, 採掘速度は木ツールの半分, Entityに対するダメージは鉄ツール相当, エンチャント補正はダイアと同じ.
	 */
	public static final EnumToolMaterial RED = EnumHelper.addToolMaterial("RED", 2, 100, 1.0F, 1.0F, 10);

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		/*
		 * ToolMaterialを追加してアイテムを生成するだけなので, 既存のクラスからインスタンスを作成する.
		 * それぞれ引数は共通で(ItemID, EnumToolMaterial), EnumHelperで作成したToolMaterialを引数に渡している.
		 */
		itemRedShovel = (new ItemSpade(10007 - 256, RED))
				.setUnlocalizedName("itemRedShovel")
				.setTextureName("tool:red_shovel")
				.setCreativeTab(CreativeTabs.tabTools);

		itemRedAxe = (new ItemAxe(10008 - 256, RED))
				.setUnlocalizedName("itemRedAxe")
				.setTextureName("tool:red_axe")
				.setCreativeTab(CreativeTabs.tabTools);

		itemRedPickaxe = (new ItemPickaxe(10009 - 256, RED))
				.setUnlocalizedName("itemRedPickaxe")
				.setTextureName("tool:red_pickaxe")
				.setCreativeTab(CreativeTabs.tabTools);

		itemRedHoe = (new ItemHoe(10010 - 256, RED))
				.setUnlocalizedName("itemRedHoe")
				.setTextureName("tool:red_hoe")
				.setCreativeTab(CreativeTabs.tabTools);

		LanguageRegistry.addName(itemRedShovel,  "Sample Item Shovel");
		LanguageRegistry.addName(itemRedAxe,     "Sample Item Axe");
		LanguageRegistry.addName(itemRedPickaxe, "Sample Item Pickaxe");
		LanguageRegistry.addName(itemRedHoe,     "Sample Item Hoe");
	}
}
