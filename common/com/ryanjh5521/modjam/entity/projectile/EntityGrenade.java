package com.ryanjh5521.modjam.entity.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

	public class EntityGrenade extends EntityThrowable
	{
	   public EntityGrenade(World par1World)
	   {
	       super(par1World);
	   }
	   public EntityGrenade(World par1World, EntityPlayer par3EntityPlayer)
	   {
	       super(par1World, par3EntityPlayer);
	   }
	   public EntityGrenade(World par1World, double par2, double par4, double par6)
	   {
	       super(par1World, par2, par4, par6);
	   }
	   @Override
	   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) 
	   {     
		   this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)15.0F, true);
		   if (par1MovingObjectPosition.entityHit != null)
	        {
	            byte b0 = 4;
	            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
	         this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)15.0F, true);
	   	     this.setDead();
	        }
	   }
	}
	
	

