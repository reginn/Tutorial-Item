// パッケージ名
package com.sample.item.basic;

// 必要なクラスのインポート
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

/*
 * modid   : 他のModと区別するID
 * name    : Modの名前
 * version : modのバージョン
 */
@Mod(
	modid = "ItemBasic",
	name  = "ItemBasic",
	version = "0.0.0"
)
public class SampleItemBasicCore {

	// Itemクラスのインスタンス, どこからでもいつでも参照するようにするためpublic staticにしてある
	public static Item itemBasic;

	// modの初期化処理を行うメソッド
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		/*
		 * itemBasicインスタンスを生成, Itemクラスの引数はItemID(内部で+256されるため, ずれないように-256している)
		 * setUnlocalizedNameは内部名
		 * setCreativeTabはクリエイティブモードのインベントリでどのタブに配置するかを決める. 今回はMaterial(素材)タブ.
		 * 今回はアイコンを設定していないので, このModを実行すると市松模様のアイテムがMaterialタブに追加される
		 */
		itemBasic = (new Item(10000 - 256)).setUnlocalizedName("itemBasic").setCreativeTab(CreativeTabs.tabMaterials);

		// 表示名を設定
		LanguageRegistry.addName(itemBasic, "Sample Item");
	}
}