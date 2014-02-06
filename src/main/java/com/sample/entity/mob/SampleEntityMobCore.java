package com.sample.entity.mob;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

@Mod(modid   = SampleEntityMobCore.MODID, version = SampleEntityMobCore.VERSION)
public class SampleEntityMobCore
{
	public static final String MODID = "EntityMob";
	public static final String VERSION = "0.0.0";

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		/*
		 * Entityを登録するメソッド
		 * 引数は(Entityのクラス, 名前, このMod内で重複しない整数, modのインスタンス, 更新範囲, 更新頻度, 更新に加速度を含むかどうか)
		 * バニラ側のEntityIDを消費しない登録メソッド.
		 * EntityIDを消費しない代わりにMobEggが追加されないので注意.
		 */
		EntityRegistry.registerModEntity(EntityMeleeSkeleton.class, "MeleeSkeleton", 0, this, 250, 1, false);

		/*
		 * Entityを自然スポーンさせるメソッド
		 * 引数は(Entityのクラス, スポーン頻度, スポーン時の最小固体数, スポーン時の最大個体数, スポーンタイプ, スポーンするバイオーム(可変長引数))
		 */
		EntityRegistry.addSpawn(EntityMeleeSkeleton.class, 20, 1, 4, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.plains});

		/*
		 * Client側のみ, RendererとEntityを関連付ける.
		 * if文でやってもいいし, proxyなどを挟んでもよい.
		 */
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityMeleeSkeleton.class, new RenderMeleeSkeleton());
		}
	}
}
