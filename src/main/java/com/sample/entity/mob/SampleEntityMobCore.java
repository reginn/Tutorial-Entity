package com.sample.entity.mob;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(
	modid   = "EntityMob",
	name    = "EntityMob",
	version = "0.0.0")
@NetworkMod(
	clientSideRequired = true,
	serverSideRequired = false)
public class SampleEntityMobCore {

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

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
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
			RenderingRegistry.registerEntityRenderingHandler(EntityMeleeSkeleton.class, new RenderMeleeSkeleton());
		}

		/*
		 * Entityに名前を付けるときのメソッド.
		 * 基本的に"entity.[registerModEntityで付けた文字列]"になる.
		 */
		LanguageRegistry.instance().addStringLocalization("entity.MeleeSkeleton", "Melee Skeleton");
	}
}
