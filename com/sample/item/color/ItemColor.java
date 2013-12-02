package com.sample.item.color;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemColor extends Item {
	/*
	 * コンストラクタ
	 * 特にやることはないのでスーパークラスのコンストラクタに引数を渡すだけ
	 */
	public ItemColor(int itemId) {
		super(itemId);
	}

	/*
	 * IconにRGBの乗算を行うメソッド
	 * クライアント側だけなのにで, SideOnlyアノテーションの付与が必要
	 * 戻り値はintなので, 0xRRGGBBを参考に乗算したい色のカラーコードを返す
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int damage) {
		return 0x0000FF;
	}
}
