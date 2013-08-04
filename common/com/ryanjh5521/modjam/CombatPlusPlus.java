package com.ryanjh5521.modjam;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

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
import com.ryanjh5521.modjam.event.SoundHandler;
import com.ryanjh5521.modjam.item.*;

@Mod(modid="combatplusplus", name="Combat++", version="0.01")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class CombatPlusPlus {

        @Instance("CombatPlusPlus")
        public static CombatPlusPlus instance;
        
        private final static Item DesertEagle = new ItemDesertEagle(300).setUnlocalizedName("gunPistol").setCreativeTab(CreativeTabs.tabCombat); 
        private final static Item GrenadeLauncher = new ItemGrenadeLauncher(200).setUnlocalizedName("gunLauncher").setCreativeTab(CreativeTabs.tabCombat);
        
        
        
        @SidedProxy(clientSide="com.ryanjh5521.modjam.proxy.ClientProxy", serverSide="com.ryanjh5521.modjam.proxy.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
        }
        
        
        @EventHandler
        public void init(FMLInitializationEvent event) {
        	    proxy.registerSoundHandler();
                LanguageRegistry.addName(GrenadeLauncher, "Grenade Launcher");
                LanguageRegistry.addName(DesertEagle, "Desert Eagle");
                EntityRegistry.registerGlobalEntityID(EntityPistolShot.class, "PistolShot", EntityRegistry.findGlobalUniqueEntityId());
                EntityRegistry.registerGlobalEntityID(EntityGrenade.class, "Grenade", EntityRegistry.findGlobalUniqueEntityId());
        }
        
        @EventHandler
        public void postInit(FMLPostInitializationEvent event) {
       
        }
}