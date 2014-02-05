package com.sample.item.bow;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid   = SampleItemBowCore.MODID, version = SampleItemBowCore.VERSION)
public class SampleItemBowCore
{
	public static final String MODID = "ItemBow";
	public static final String VERSION = "0.0.0";

	public static Item itemBow;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*
		 * ItemBowを継承したItemSampleBowクラスでインスタンスを生成する.
		 * setTextureNameしていないのは, ItemBowクラスのregisterIconsで"バニラの弓アニメーション"アイコンをロードしているためである.
		 * ItemSampleBowではバニラのアイコンをロードしないため, こうしている.
		 * setFull3D()は他人から見たとき/F5で三人称にしたときの手に持っている描画を剣やツールなどと同様にするためのメソッド.
		 * バニラの弓は専用の描画方式なのだが, RenderPlayer内で"if(itemstack.itemID == Item.bow.itemID)"という
		 * 判定を行っているため, modで追加する弓の描画をバニラと同等のものにするにはやや大変(IItemRendererを利用する必要あり).
		 * そのため, 今回は簡単に出来て"それっぽい"描画方式にしている.
		 */
		itemBow = (new ItemSampleBow())
				.setUnlocalizedName("itemBow")
				.setFull3D();

		GameRegistry.registerItem(itemBow, "ItemBow");
	}
}
