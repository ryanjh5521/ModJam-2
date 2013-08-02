package com.ryanjh5521.modjam;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.ryanjh5521.modjam.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import com.ryanjh5521.modjam.entity.projectile.EntityGrenade;
import com.ryanjh5521.modjam.entity.projectile.EntityPistolShot;
import com.ryanjh5521.modjam.item.*;

@Mod(modid="combatplusplus", name="Combat++", version="0.01")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class CombatPlusPlus {

        @Instance("CombatPlusPlus")
        public static CombatPlusPlus instance;
        
        private final static Item ItemPistol = new ItemPistol(5000).setCreativeTab(CreativeTabs.tabCombat);
        
        private final static Item ItemGrenadeLauncher = new ItemGrenadeLauncher(5001).setCreativeTab(CreativeTabs.tabCombat);
        
        
        @SidedProxy(clientSide="com.ryanjh5521.modjam.proxy.ClientProxy", serverSide="com.ryanjh5521.modjam.proxy.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                LanguageRegistry.addName(ItemPistol, "Colt M1911");
                
                LanguageRegistry.addName(ItemGrenadeLauncher, "Grenade Launcher");
                EntityRegistry.registerGlobalEntityID(EntityPistolShot.class, "PistolShot", EntityRegistry.findGlobalUniqueEntityId());
                EntityRegistry.registerGlobalEntityID(EntityGrenade.class, "Grenade", EntityRegistry.findGlobalUniqueEntityId());
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
       
        }
}