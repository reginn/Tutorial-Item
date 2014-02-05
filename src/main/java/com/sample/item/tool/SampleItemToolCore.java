package com.sample.item.tool;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = SampleItemToolCore.MODID, version = SampleItemToolCore.VERSION)
public class SampleItemToolCore
{
	public static final String MODID = "ItemTool";
	public static final String VERSION = "0.0.0";

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
	public static final Item.ToolMaterial RED = EnumHelper.addToolMaterial("RED", 2, 100, 1.0F, 1.0F, 10);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		 * ToolMaterialを追加してアイテムを生成するだけなので, 既存のクラスからインスタンスを作成する.
		 * それぞれ引数は共通で(ItemID, EnumToolMaterial), EnumHelperで作成したToolMaterialを引数に渡している.
		 * 全てクリエイティブタブのツールタブに追加する.
		 */
		itemRedShovel = (new ItemSpade(RED))
				.setUnlocalizedName("itemRedShovel")
				.setTextureName("tool:red_shovel")
				.setCreativeTab(CreativeTabs.tabTools);

		/*
		 * 斧とつるはしだけコンストラクタがprotectedなので, 元のクラスを継承したクラスを利用
		 */
		itemRedAxe = (new ItemSampleAxe(RED))
				.setUnlocalizedName("itemRedAxe")
				.setTextureName("tool:red_axe")
				.setCreativeTab(CreativeTabs.tabTools);

		itemRedPickaxe = (new ItemSamplePickaxe(RED))
				.setUnlocalizedName("itemRedPickaxe")
				.setTextureName("tool:red_pickaxe")
				.setCreativeTab(CreativeTabs.tabTools);

		itemRedHoe = (new ItemHoe(RED))
				.setUnlocalizedName("itemRedHoe")
				.setTextureName("tool:red_hoe")
				.setCreativeTab(CreativeTabs.tabTools);

		GameRegistry.registerItem(itemRedShovel,  "ItemRedShovel");
		GameRegistry.registerItem(itemRedAxe,     "ItemRedAxe");
		GameRegistry.registerItem(itemRedPickaxe, "ItemRedPickaxe");
		GameRegistry.registerItem(itemRedHoe,     "ItemRedHoe");
	}
}
