package com.sample.item.food;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

@Mod(modid = SampleItemFoodCore.MODID, version = SampleItemFoodCore.VERSION)
public class SampleItemFoodCore
{
	public static final String MODID   = "ItemFood";
	public static final String VERSION = "0.0.0";

	public static Item itemFood;
	public static Item itemFoodWithPotionEffect;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		 * 食べられる石炭, 食べたときの回復量はパンと同じ
		 * ItemFoodの引数は(ItemID, 空腹度の回復量, 腹もちのよさ, オオカミの餌に出来るかどうか)
		 * 他は今まで通り
		 * クリエイティブタブの食べ物タブに追加する.
		 */
		itemFood = (new ItemFood(5, 0.6F, false))
				.setUnlocalizedName("itemFood")
				.setTextureName("coal")
				.setCreativeTab(CreativeTabs.tabFood);

		/*
		 * １つのポーション効果を持たせる場合
		 * setPotionEffectは必ず最初にやること
		 * setPotionEffectの引数は(ポーションID, 効果時間(秒), ポーションの効果レベル, この効果が発動する確率)
		 */
		itemFoodWithPotionEffect = (new ItemFood(5, 0.6F, false))
				.setPotionEffect(Potion.jump.id, 30, 0, 0.8F)
				.setUnlocalizedName("itemFoodWithPotionEffect")
				.setTextureName("charcoal")
				.setCreativeTab(CreativeTabs.tabFood);

		GameRegistry.registerItem(itemFood, "ItemFood");
		GameRegistry.registerItem(itemFoodWithPotionEffect, "ItemFoodWithPotionEffect");
	}
}
