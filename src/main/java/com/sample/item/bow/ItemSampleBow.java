package com.sample.item.bow;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemSampleBow extends ItemBow
{
	/*
	 * 弓のアニメーション用のアイコンの配列
	 */
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemSampleBow()
	{
		super();
	}

	/*
	 * itemIconは弓を引いてないときのアイコン
	 * それ以外は弓を引いているときのアイコン
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
    {
		this.itemIcon = iconRegister.registerIcon("bow:black_bow_standby");
		this.icons = new IIcon[3];
		this.icons[0] = iconRegister.registerIcon("bow:black_bow_pulling_0");
		this.icons[1] = iconRegister.registerIcon("bow:black_bow_pulling_1");
		this.icons[2] = iconRegister.registerIcon("bow:black_bow_pulling_2");
	}

	/*
	 * 弓を引いてるときのアニメーションを設定するメソッド.
	 * 右クリック長押しでアニメーションさせたいときはこのメソッドを利用する.
	 * stackとrenderPassがあるので, ItemStackのNBTを利用したり複数アイコンを重ね合わせることも可能.
	 * playerは弓を引いてるプレイヤー, usingItemはこのアイテム, useRemainingは引いている時間
	 * getMaxItemUseDuration()が引く動作時間の最大値で, その最大値と現在の引いてる時間の差でアイコンを変更してアニメーションさせている
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if (usingItem != null && usingItem.getItem() instanceof ItemSampleBow)
		{
			int k = usingItem.getMaxItemUseDuration() - useRemaining;
			if (k >= 18) return this.icons[2];
			if (k >  13) return this.icons[1];
			if (k >  0)  return this.icons[0];
		}

		return super.getIcon(stack, renderPass, player, usingItem, useRemaining);
	}
}
