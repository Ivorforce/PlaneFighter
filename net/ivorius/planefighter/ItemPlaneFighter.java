package net.ivorius.planefighter;

import java.util.List;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.BlockRailBase;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemPlaneFighter extends Item
{
	public ItemPlaneFighter(int par1)
	{
		super(par1);
		
		setMaxStackSize(1);
	}
	
	@Override
	public void getSubItems( int par1, CreativeTabs par2CreativeTabs, List par3List )
	{
		for (byte body = 0; body < ItemPlaneFighterPart.bodyNames.length; body++)
		    for (byte wing = 0; wing < ItemPlaneFighterPart.wingNames.length; wing++)
			    for (byte weapon = 0; weapon < ItemPlaneFighterPart.weaponNames.length; weapon++)
			    {
			    	ItemStack stack = new ItemStack(this);
			    	stack.setTagInfo("planeBodyType", new NBTTagByte("planeBodyType", body));
			    	stack.setTagInfo("planeWingType", new NBTTagByte("planeWingType", wing));
			    	stack.setTagInfo("planeWeaponType", new NBTTagByte("planeWeaponType", weapon));
			    	par3List.add(stack);
			    }
	}
	
	@Override
	public void addInformation( ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4 )
	{
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
		
		NBTTagCompound compound = par1ItemStack.getTagCompound();
		if (compound !=  null)
		{
			byte body = compound.getByte("planeBodyType");
			byte wings = compound.getByte("planeWingType");
			byte weapon = compound.getByte("planeWeaponType");
			
			par3List.add(EnumChatFormatting.GRAY + String.format(StatCollector.translateToLocalFormatted("item.planefighterPart.body" + body + ".name"), new Object[0]));
			par3List.add(EnumChatFormatting.GRAY + String.format(StatCollector.translateToLocalFormatted("item.planefighterPart.wing" + wings + ".name"), new Object[0]));
			par3List.add(EnumChatFormatting.GRAY + String.format(StatCollector.translateToLocalFormatted("item.planefighterPart.weapon" + weapon + ".name"), new Object[0]));			
		}
	}
	
	@Override
	public void registerIcons( IconRegister par1IconRegister )
	{
		this.itemIcon = par1IconRegister.registerIcon("planefighter:planefighter");
	}
	
	@Override
	public boolean onItemUse( ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10 )
	{
        if (par7 != 1)
            return false;

        if (!par3World.isRemote)
        {
            EntityPlaneFighter planefighter = new EntityPlaneFighter(par3World);
            planefighter.setPosition(par4 + 0.5, par5 + 1.5, par6 + 0.5);
            
            if (par1ItemStack.hasDisplayName())
            {
//                planefighter.setCustomNameTag(par1ItemStack.getDisplayName());
            }

    		NBTTagCompound compound = par1ItemStack.getTagCompound();
    		if (compound !=  null)
    		{
    			byte body = compound.getByte("planeBodyType");
    			byte wings = compound.getByte("planeWingType");
    			byte weapon = compound.getByte("planeWeaponType");
    			
    			planefighter.setBodyType(body);
    			planefighter.setWingType(wings);
    			planefighter.setWeaponType(weapon);
    		}            
            par3World.spawnEntityInWorld(planefighter);
        }

        --par1ItemStack.stackSize;
        return true;
	}
}
