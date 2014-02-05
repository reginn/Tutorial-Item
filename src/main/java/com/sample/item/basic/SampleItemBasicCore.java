package com.sample.item.basic;

// 必要なクラスのインポート

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/*
 * modid   : 他のModと区別するID
 * version : modのバージョン
 */
@Mod(modid = SampleItemBasicCore.MODID, version = SampleItemBasicCore.VERSION)
public class SampleItemBasicCore
{
	public static final String MODID = "ItemBasic";
	public static final String VERSION = "0.0.0";

	// Itemクラスのインスタンス, どこからでもいつでも参照するようにするためpublic staticにしてある
	public static Item itemBasic;

	// modの初期化処理を行うメソッド
	// 1.7以降Itemの追加はPreInitで行うようになった.
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
    {
		/*
		 * itemBasicインスタンスを生成
		 * setUnlocalizedNameは内部名
		 * setCreativeTabはクリエイティブモードのインベントリでどのタブに配置するかを決める. 今回はMaterial(素材)タブ.
		 * 今回はアイコンを設定していないので, このModを実行すると市松模様のアイテムがMaterialタブに追加される
		 */
		itemBasic = (new Item())
				.setUnlocalizedName("itemBasic")
				.setCreativeTab(CreativeTabs.tabMaterials);

		/*
		 * 1.7以降Itemの追加もregisterItemを利用するようになった.
		 */
		GameRegistry.registerItem(itemBasic, "ItemBasic");
		/*
		 * 表示名を設定
		 * 1.7からassets以下におかれたlangファイルを参照するようになり, 以下のメソッドは非推奨に.
		 * resources/assets/domain/lang/en_US.langを自動で参照する.
		 * 日本語ならja_JP.langをおいておけばよい.
		 */
		// LanguageRegistry.addName(itemBasic, "Sample Item");
	}
}