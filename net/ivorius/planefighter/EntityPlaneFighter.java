package net.ivorius.planefighter;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityPlaneFighter extends EntityLiving
{
	public static Field isJumpingField = null;

	public float planeRoll = 0.0f;

	public int explosionStrength = 2;

	public int shootDelay;

	public EntityPlaneFighter(World par1World)
	{
		super(par1World);

		this.width = 1.0f;
		this.height = 1.0f;

		this.stepHeight = 0.0f;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(24.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(1.0D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();

		this.dataWatcher.addObject(20, Byte.valueOf((byte) 0));
		this.dataWatcher.addObject(21, Byte.valueOf((byte) 0));
		this.dataWatcher.addObject(22, Byte.valueOf((byte) 0));
	}

	public double getMountedYOffset()
	{
		return -0.5;
	}

	@Override
	protected void onDeathUpdate()
	{
		if (this.deathTime < 19)
			this.deathTime = 19; //Skip the falling over part
		super.onDeathUpdate();
	}

	@Override
	public void onDeath( DamageSource par1DamageSource )
	{
		super.onDeath(par1DamageSource);

		for (int i = 0; i < 5; i++)
			worldObj.spawnParticle("lava", this.posX + rand.nextDouble() - 0.5, this.posY + rand.nextDouble() - 0.5, this.posZ + rand.nextDouble() - 0.5, 0.0f, 0.0f, 0.0f);
		for (int i = 0; i < 20; i++)
			worldObj.spawnParticle("tilecrack_" + Block.planks.blockID + "_" + 0, this.posX + rand.nextDouble() - 0.5, this.posY + rand.nextDouble() - 0.5, this.posZ + rand.nextDouble() - 0.5, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void updateRiderPosition()
	{
		if (this.riddenByEntity != null)
		{
			double headDist = 0.4;

			Vector3f cockpitPos = getCockpitVector();

			double posXP = cockpitPos.x;
			double posYP = cockpitPos.y;
			double posZP = cockpitPos.z;

			this.riddenByEntity.setPosition(this.posX + posXP, this.posY + posYP, this.posZ + posZP);
		}
	}

	public Vector3f getTransformedShipVector( float shipX, float shipY, float shipZ )
	{
		Vector3f shipPosVec = new Vector3f(shipX, shipY, shipZ);
		Vector3f destVec = new Vector3f();
		Matrix3f.transform(getRotationTransformMatrix(), shipPosVec, destVec);

		return destVec;
	}

	public Vector3f getCockpitVector()
	{
		return getTransformedShipVector(0.0f, 0.38f, 0.45f);
	}

	public Matrix3f getRotationTransformMatrix()
	{
		float yaw = this.rotationYaw / 180.0F * (float) Math.PI;
		float pitch = this.rotationPitch / 180.0F * (float) Math.PI;
		float roll = this.planeRoll / 180.0F * (float) Math.PI;

		Matrix3f rotationYawMatrix = new Matrix3f();
		rotationYawMatrix.m00 = MathHelper.cos(yaw);
		rotationYawMatrix.m02 = MathHelper.sin(yaw);
		rotationYawMatrix.m11 = 1;
		rotationYawMatrix.m20 = -MathHelper.sin(yaw);
		rotationYawMatrix.m22 = MathHelper.cos(yaw);

		Matrix3f rotationPitchMatrix = new Matrix3f();
		rotationPitchMatrix.m00 = 1;
		rotationPitchMatrix.m11 = MathHelper.cos(pitch);
		rotationPitchMatrix.m12 = MathHelper.sin(pitch);
		rotationPitchMatrix.m21 = -MathHelper.sin(pitch);
		rotationPitchMatrix.m22 = MathHelper.cos(pitch);

		Matrix3f rotationRollMatrix = new Matrix3f();
		rotationRollMatrix.m00 = MathHelper.cos(roll);
		rotationRollMatrix.m01 = -MathHelper.sin(roll);
		rotationRollMatrix.m10 = MathHelper.sin(roll);
		rotationRollMatrix.m11 = MathHelper.cos(roll);

		Matrix3f pitchYawMatrix = new Matrix3f();
		Matrix3f.mul(rotationYawMatrix, rotationPitchMatrix, pitchYawMatrix);

		Matrix3f pitchYawRollMatrix = new Matrix3f();
		Matrix3f.mul(pitchYawMatrix, rotationRollMatrix, pitchYawRollMatrix);

		return pitchYawRollMatrix;
	}

	public boolean interact( EntityPlayer par1EntityPlayer )
	{
		if (super.interact(par1EntityPlayer))
		{
			return true;
		}
		else if (!this.worldObj.isRemote && this.riddenByEntity == par1EntityPlayer)
		{
			if (this.shootDelay <= 0)
				this.fireWeapon();

			return true;
		}
		else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
		{
			par1EntityPlayer.mountEntity(this);
			return true;
		}
		else
		{
			return false;
		}
	}

	public void fireWeapon()
	{
		if (this.getWeaponType() == 1)
		{
			Vector3f gunVec = getTransformedShipVector(0.0f, -1.2f, 0.0f);
			Vec3 look = this.getLook(1.0f);

			double d5 = look.xCoord;
			double d6 = look.yCoord;
			double d7 = look.zCoord;

			EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj, this, d5, d6, d7);
			entitylargefireball.field_92057_e = this.explosionStrength;
			entitylargefireball.posX = gunVec.x + this.posX;
			entitylargefireball.posY = gunVec.y + this.posY;
			entitylargefireball.posZ = gunVec.z + this.posZ;
			entitylargefireball.motionX = this.motionX + look.xCoord;
			entitylargefireball.motionY = this.motionY + look.yCoord;
			entitylargefireball.motionZ = this.motionZ + look.zCoord;
			entitylargefireball.accelerationX = this.motionX * 0.1f;
			entitylargefireball.accelerationY = this.motionY * 0.1f;
			entitylargefireball.accelerationZ = this.motionZ * 0.1f;
			this.worldObj.spawnEntityInWorld(entitylargefireball);

			this.shootDelay = 60;
		}
		else
		{
			Vec3 look = this.getLook(1.0f);
			Vector3f gunVec1 = getTransformedShipVector(0.5f, -1.2f, 0.0f);
			Vector3f gunVec2 = getTransformedShipVector(-0.5f, -1.2f, 0.0f);

			EntityArrow arrow = new EntityArrow(worldObj, this, 1.0f);
			arrow.setPosition(gunVec1.x + this.posX, gunVec1.y + this.posY, gunVec1.z + this.posZ);
			arrow.motionX = this.motionX + look.xCoord;
			arrow.motionY = this.motionY + look.yCoord;
			arrow.motionZ = this.motionZ + look.zCoord;
			this.worldObj.spawnEntityInWorld(arrow);

			EntityArrow arrow1 = new EntityArrow(worldObj, this, 1.0f);
			arrow1.setPosition(gunVec2.x + this.posX, gunVec2.y + this.posY, gunVec2.z + this.posZ);
			arrow1.motionX = this.motionX + look.xCoord;
			arrow1.motionY = this.motionY + look.yCoord;
			arrow1.motionZ = this.motionZ + look.zCoord;
			this.worldObj.spawnEntityInWorld(arrow1);

			this.shootDelay = 5;
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.shootDelay > 0)
			this.shootDelay--;

		if (this.riddenByEntity != null)
			((EntityLivingBase) this.riddenByEntity).addPotionEffect(new PotionEffect(Potion.invisibility.id, 5));

		float totalMotion = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
		if (totalMotion > 0.4f)
		{
			int delay = 15 - MathHelper.ceiling_double_int((totalMotion - 0.4f) * 30.0f);
			if (delay < 1)
				delay = 1;

			if ((this.ticksExisted % delay) == 0)
			{
				Vector3f dest1Vec = getTransformedShipVector(-0.7f, 0.38f, -1.5f);
				Vector3f dest2Vec = getTransformedShipVector(0.7f, 0.38f, -1.5f);

				worldObj.spawnParticle("cloud", this.posX + dest1Vec.x, this.posY + dest1Vec.y, this.posZ + dest1Vec.z, 0.0f, 0.0f, 0.0f);
				worldObj.spawnParticle("cloud", this.posX + dest2Vec.x, this.posY + dest2Vec.y, this.posZ + dest2Vec.z, 0.0f, 0.0f, 0.0f);
			}

		}
	}

	@Override
	protected void updateEntityActionState()
	{

	}

	public void moveEntityWithHeading( float par1, float par2 )
	{
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;

		double prevMotionX = this.motionX;
		double prevMotionZ = this.motionZ;

		if (!this.onGround)
		{
			float airFrictionN = 1.0f - this.getAirFriction();
			this.motionX *= airFrictionN;
			this.motionY *= airFrictionN;
			this.motionZ *= airFrictionN;
		}
		else
		{
			this.motionX *= 0.95f;
			this.motionY *= 0.95f;
			this.motionZ *= 0.95f;
		}

		float piF = (float) Math.PI;
		double dirX = (double) (-MathHelper.sin(this.rotationYaw / 180.0F * piF) * MathHelper.cos(this.rotationPitch / 180.0F * piF));
		double dirZ = (double) (MathHelper.cos(this.rotationYaw / 180.0F * piF) * MathHelper.cos(this.rotationPitch / 180.0F * piF));
		double dirY = (double) (-MathHelper.sin(this.rotationPitch / 180.0F * piF));

		float totalMotion = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);

		if (this.riddenByEntity != null)
		{
			float turnSpeed = this.getTurnSpeed();
			float rollPlus = ((EntityLivingBase) this.riddenByEntity).moveStrafing * turnSpeed;
			float pitchPlus = ((EntityLivingBase) this.riddenByEntity).moveForward * turnSpeed * 1.3f;

			par1 = 0; // lol strafing
			par2 = this.getEntityJumping((EntityLivingBase) this.riddenByEntity) ? 1.0f : 0.0f; // Fuck mojang n shit, technical limitations = always thrust

			this.rotationYaw = this.rotationYaw - rollPlus;
			this.rotationPitch = this.rotationPitch + pitchPlus;

			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;

			float acceleration = this.getAcceleration();
			this.motionX += dirX * acceleration * par2 * (this.onGround ? 4 : 1);
			this.motionY += dirY * acceleration * par2 * (this.onGround ? 4 : 1);
			this.motionZ += dirZ * acceleration * par2 * (this.onGround ? 4 : 1);
		}
		else
		{
			if (!this.onGround)
				this.rotationPitch += Math.min(1.0f, 90.0f - this.rotationPitch);
		}

		if (totalMotion > 0)
		{
			Vector3f motionVec = new Vector3f((float) motionX, (float) motionY, (float) motionZ);
			Vector3f dirVec = new Vector3f((float) dirX * totalMotion, (float) dirY * totalMotion, (float) dirZ * totalMotion);
			float angleACos = Vector3f.dot(dirVec, motionVec) / (totalMotion * totalMotion);
			float influence = 0.8f;
			float match = influence * angleACos;

			this.motionX -= this.motionX * influence;
			this.motionY -= this.motionY * influence;
			this.motionZ -= this.motionZ * influence;
			this.motionX += dirVec.x * match;
			this.motionY += dirVec.y * match;
			this.motionZ += dirVec.z * match;
		}

		if (this.onGround)
			this.rotationPitch = -5.0f;

		this.motionY -= 0.06D;

		this.moveEntity(this.motionX, this.motionY, this.motionZ);

		if (this.isCollidedHorizontally)
		{
			float collideMotionX = (float) MathHelper.sqrt_double((prevMotionX - this.motionX) * (prevMotionX - this.motionX));
			float collideMotionZ = (float) MathHelper.sqrt_double((prevMotionZ - this.motionZ) * (prevMotionZ - this.motionZ));

			this.attackEntityFrom(DamageSource.fall, (collideMotionX + collideMotionZ) * 15);

			if (this.riddenByEntity != null)
				this.riddenByEntity.attackEntityFrom(DamageSource.fall, (collideMotionX + collideMotionZ) * 15);
		}

		if (this.rotationPitch > 90.0f)
			this.rotationPitch = 90.0f;
		if (this.rotationPitch < -90.0f)
			this.rotationPitch = -90.0f;
		this.setRotation(this.rotationYaw, this.rotationPitch);

		float yawChange = this.prevRotationYaw - this.rotationYaw;
		if (yawChange > 180.0f)
			yawChange = 360.0f - yawChange;
		if (yawChange < -180.0f)
			yawChange = -360.0f - yawChange;

		this.planeRoll = this.planeRoll + (yawChange * 20.0f - this.planeRoll) * 0.05f;

		if (this.riddenByEntity != null)
		{
			this.riddenByEntity.rotationYaw += this.rotationYaw - this.prevRotationYaw;
			this.riddenByEntity.rotationPitch += this.rotationPitch - this.prevRotationPitch;
		}
	}

	// I may use coremods next time. For a quick mod, this is certainly much faster :P
	public boolean getEntityJumping( EntityLivingBase entity ) // Also, fuck your programming, guys. That is all. :<
	{
		if (isJumpingField == null)
		{
			try
			{
				isJumpingField = EntityLivingBase.class.getDeclaredField("isJumping");
			}
			catch (SecurityException e)
			{
				e.printStackTrace();
			}
			catch (NoSuchFieldException e)
			{

			}
			
			if (isJumpingField == null)
			{
				try
				{
					isJumpingField = EntityLivingBase.class.getDeclaredField("field_70703_bu");
				}
				catch (SecurityException e)
				{
					e.printStackTrace();
				}
				catch (NoSuchFieldException e)
				{
					e.printStackTrace();
				}				
			}
			
			if (isJumpingField != null)
				isJumpingField.setAccessible(true);
		}

		if (isJumpingField != null)
		{
			try
			{
				return isJumpingField.getBoolean(entity);
			}
			catch (IllegalArgumentException e)
			{
				e.printStackTrace();
			}
			catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	protected void fall( float par1 )
	{
		super.fall((float) MathHelper.sqrt_double(this.motionY * this.motionY) * 15.0f);
	}

	public byte getBodyType()
	{
		return this.dataWatcher.getWatchableObjectByte(20);
	}

	public void setBodyType( byte bodyType )
	{
		this.dataWatcher.updateObject(20, new Byte(bodyType));

		float newMaxHealth = this.getMaxHealthPlane();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(newMaxHealth);
		this.setHealth(newMaxHealth);
	}

	public byte getWingType()
	{
		return this.dataWatcher.getWatchableObjectByte(21);
	}

	public void setWingType( byte wingType )
	{
		this.dataWatcher.updateObject(21, new Byte(wingType));
	}

	public byte getWeaponType()
	{
		return this.dataWatcher.getWatchableObjectByte(22);
	}

	public void setWeaponType( byte weaponType )
	{
		this.dataWatcher.updateObject(22, new Byte(weaponType));
	}

	public float getAcceleration()
	{
		if (this.getWingType() == 0)
			return 0.0175f;
		if (this.getWingType() == 1)
			return 0.024f;

		return 0.02f;
	}

	public float getAirFriction()
	{
		if (this.getWingType() == 0)
			return 0.01f;
		if (this.getWingType() == 1)
			return 0.018f;

		return 0.03f;
	}

	public float getTurnSpeed()
	{
		if (this.getBodyType() == 0)
			return 2.0f;
		if (this.getBodyType() == 1)
			return 3.0f;

		return 2.0f;
	}

	public float getMaxHealthPlane()
	{
		if (this.getBodyType() == 0)
			return 30.0f;
		if (this.getBodyType() == 1)
			return 10.0f;

		return 12.0f;
	}

	@Override
	public void writeEntityToNBT( NBTTagCompound par1nbtTagCompound )
	{
		super.writeEntityToNBT(par1nbtTagCompound);

		par1nbtTagCompound.setByte("bodyType", this.getBodyType());
		par1nbtTagCompound.setByte("wingType", this.getWingType());
		par1nbtTagCompound.setByte("weaponType", this.getWeaponType());

		par1nbtTagCompound.setInteger("shootDelay", shootDelay);
	}

	@Override
	public void readEntityFromNBT( NBTTagCompound par1nbtTagCompound )
	{
		super.readEntityFromNBT(par1nbtTagCompound);

		this.setBodyType(par1nbtTagCompound.getByte("bodyType"));
		this.setWingType(par1nbtTagCompound.getByte("wingType"));
		this.setWeaponType(par1nbtTagCompound.getByte("weaponType"));

		shootDelay = (par1nbtTagCompound.getInteger("shootDelay"));
	}
}
