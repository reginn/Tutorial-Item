package com.sample.item.icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemColor extends Item
{
	/*
	 * コンストラクタ
	 * 特にやることはないのでスーパークラスのコンストラクタに引数を渡すだけ.
	 */
	public ItemColor()
    {
		super();
	}

	/*
	 * IconにRGBの乗算を行うメソッド
	 * クライアント側だけなのにで, SideOnlyアノテーションの付与が必要.
	 * 戻り値はintなので, 0xRRBBGGを参考に乗算したい色のカラーコードを返す.
	 * 引数はItemStackとItemStackのダメージ値, そのためItemStackのNBTやダメージ値によって乗算する色を変えることも可能.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int damage)
	{
		return 0x0000FF;
	}
}
