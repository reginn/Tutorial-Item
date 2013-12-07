package com.sample.item.icon;

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

	public ItemComplex(int itemID) {
		super(itemID);
	}

	/*
	 * Iconを登録するメソッド.
	 * クライアントのみなのでSideOnlyアノテーションの付与が必要.
	 * registerIconの引数は, setTextureNameの引数と同じ.
	 * まずsuper.registerIcons()をする必要がある.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		super.registerIcons(iconRegister);
		overIcon  = iconRegister.registerIcon("icon:rect");
	}

	/*
	 * Iconでレイヤーを利用するかどうかを返すメソッド
	 * クライアントのみなのでSideOnlyアノテーションの付与が必要.
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
	 * クライアントのみなのでSideOnlyアノテーションの付与が必要.
	 * 今回は四角系が上で, バツ印が下になるように設定.
	 * 引数のダメージ値を利用すればより複雑な処理が可能.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamageForRenderPass(int damage, int renderPass)
	{
		return renderPass > 0 ? this.overIcon : this.itemIcon;
	}

}
