package com.ryanjh5521.modjam.item;

import com.ryanjh5521.modjam.entity.projectile.EntityPistolShot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPistol extends Item
{
  public ItemPistol(int id)
  {
    super(id);
  }
  @Override
  public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,EntityPlayer par3EntityPlayer) {
    if(par3EntityPlayer.capabilities.isCreativeMode||par3EntityPlayer.inventory.consumeInventoryItem(Item.diamond.itemID))
    {
      par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
      if (!par2World.isRemote)
      {
        par2World.spawnEntityInWorld(new EntityPistolShot(par2World, par3EntityPlayer));
      }
    }
    return par1ItemStack;
    }
}