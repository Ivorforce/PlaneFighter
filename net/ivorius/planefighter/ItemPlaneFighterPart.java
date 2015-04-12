package net.ivorius.planefighter;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemPlaneFighterPart extends Item
{
	public static final String[] bodyNames = new String[] { "Heavy Plane Body", "Light Plane Body" };
	public static final String[] wingNames = new String[] { "Aerodynamic Plane Wings", "Clockwork Plane Wings" };
	public static final String[] weaponNames = new String[] { "Plane Arrow Launcher", "Plane Cannon" };

	public Icon wingsIcon;
	public Icon weaponIcon;
	
	public ItemPlaneFighterPart(int par1)
	{
		super(par1);

		setMaxStackSize(1);
		hasSubtypes = true;
	}

	@Override
	public void getSubItems( int par1, CreativeTabs par2CreativeTabs, List par3List )
	{
		for (int i = 0; i < bodyNames.length; i++)
			par3List.add(new ItemStack(this, 1, i));

		for (int i = 0; i < wingNames.length; i++)
			par3List.add(new ItemStack(this, 1, i + 128));

		for (int i = 0; i < weaponNames.length; i++)
			par3List.add(new ItemStack(this, 1, i + 256));
	}
	
	@Override
	public String getUnlocalizedName( ItemStack par1ItemStack )
	{
		int dmg = par1ItemStack.getItemDamage();

		if (dmg <  128)
			return super.getUnlocalizedName(par1ItemStack) + ".body" + dmg; 
		else if (dmg < 256)
			return super.getUnlocalizedName(par1ItemStack) + ".wing" + (dmg - 128); 
		else
			return super.getUnlocalizedName(par1ItemStack) + ".weapon" + (dmg - 256); 
	}
	
	@Override
	public void registerIcons( IconRegister par1IconRegister )
	{
		this.itemIcon = par1IconRegister.registerIcon("planefighter:planeBody");
		this.wingsIcon = par1IconRegister.registerIcon("planefighter:planeWings");
		this.weaponIcon = par1IconRegister.registerIcon("planefighter:planeGun");
	}
	
	@Override
	public Icon getIconFromDamage( int par1 )
	{
		if (par1 < 128)
			return this.itemIcon;
		else if (par1 < 256)
			return this.wingsIcon;
		else
			return this.weaponIcon;
	}
}
