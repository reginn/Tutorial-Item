package com.sample.item.complex;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemComplex extends Item {
	/*
	 * Iconクラスはクライアントのみなので, SideOnlyアノテーションの付与が必要
	 */
	@SideOnly(Side.CLIENT)
	Icon overIcon;

	@SideOnly(Side.CLIENT)
	Icon underIcon;

	public ItemComplex(int itemId) {
		super(itemId);
	}

	/*
	 * Iconを登録する
	 * registerIconの引数は, setTextureNameの引数と同じ
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		overIcon   = iconRegister.registerIcon("complex:rect");
		underIcon = iconRegister.registerIcon("complex:cross");
	}

	/*
	 * Iconでレイヤーを利用するかどうかを返すメソッド
	 * 今回は利用するのでtrueを返している
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	/*
	 * renderPass(描画の順序)を設定するメソッド
	 * 今回は四角系が上で, バツ印が下になるように設定
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamageForRenderPass(int damage, int renderPass)
	{
		return renderPass > 0 ? this.overIcon : this.underIcon;
	}

}
