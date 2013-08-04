package com.ryanjh5521.modjam.event;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundHandler {
	@ForgeSubscribe
    public void onSoundLoad(SoundLoadEvent event)
    {
        try 
        {
            event.manager.addSound("combatplusplus:gunshot.wav");
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }
}
