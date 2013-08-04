package com.ryanjh5521.modjam.proxy;

import com.ryanjh5521.modjam.event.SoundHandler;

import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	public void registerSoundHandler() {
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
		
	}
}
