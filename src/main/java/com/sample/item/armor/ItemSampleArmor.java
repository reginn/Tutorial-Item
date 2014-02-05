package com.sample.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemSampleArmor extends ItemArmor
{
	/*
	 * スーパークラス(ItemArmor)のコンストラクタを呼び初期化する.
	 * ItemArmorのコンストラクタの第3引数はバニラのテクスチャを参照するのに使うため, 今回は使わないので0
	 */
	public ItemSampleArmor(ItemArmor.ArmorMaterial material, int armorType)
	{
		super(material, 0, armorType);
	}

	/*
	 * 防具を装備したときのテクスチャのファイルパスを返すメソッド.
	 * 防具はレギンスだけ1つのテクスチャファイルなので注意.
	 * テクスチャファイルの仕様はバニラの防具のテクスチャを参照のこと.
	 * ヘルメット, プレート, ブーツは1つのテクスチャファイル
	 * テクスチャファイルへのパスは"domain:パス"で, setTextureNameと若干異なるので注意. ".png"が必要.
	 * 今回は常にこのテクスチャにするようにしているが, 引数のItemStackは防具, Entityは装備しているEntityなので,
	 * NBTやダメージ値, Entityの種類によって返すテクスチャを変更することも可能.
	 *
	 * 引数について
	 * stack  : この防具自体のItemStack
	 * entity : この防具を身につけているEntity
	 * slot   : 装備しているアイテムスロット, 基本的に
	 * ヘルメット = 0
	 * プレート    = 1
	 * レギンス    = 2
	 * ブーツ        = 3
	 * type : バニラの革防具のようにする場合に利用する. 今回は利用しない.
	 */
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (this.armorType == SampleItemArmorCore.LEGGINGS)
		{
			return "armor:textures/models/armor/green_layer_2.png";
		}
		return "armor:textures/models/armor/green_layer_1.png";
	}
}
