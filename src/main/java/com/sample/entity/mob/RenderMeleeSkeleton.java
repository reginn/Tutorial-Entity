package com.sample.entity.mob;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

/*
 * 今回は二本足のEntityを追加するので, RenderBipedを継承する.
 */
public class RenderMeleeSkeleton extends RenderBiped
{
	/*
	 * テクスチャへのResourceLocationを設定する.
	 */
	private static final ResourceLocation skeletonTextures = new ResourceLocation("entity:textures/mob/red_skeleton.png");

	public RenderMeleeSkeleton()
	{
		/*
		 * スーパークラスのコンストラクタの引数は
		 * (このRenderと紐付けするModel, このRenderを使うEntityの足元の影の大きさ)
		 */
		super(new ModelMeleeSkeleton(), 0.5F);
	}

	/*
	 * このRenderが利用するテクスチャのResourceLocationを返す.
	 */
	@Override
	protected ResourceLocation getEntityTexture(EntityLiving par1EntityLiving)
	{
		return this.skeletonTextures;
	}
}
