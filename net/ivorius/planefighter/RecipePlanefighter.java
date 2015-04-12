package net.ivorius.planefighter;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.world.World;

public class RecipePlanefighter implements IRecipe
{
    public boolean matches(InventoryCrafting par1InventoryCrafting, World par2World)
    {
    	ItemStack[] parts = new ItemStack[3];

        for (int j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
        {
            ItemStack itemstack1 = par1InventoryCrafting.getStackInSlot(j);

            if (itemstack1 != null)
            {
                if (itemstack1.itemID == PlaneFighter.itemPlaneFighterPart.itemID)
                {
                    int dmg = itemstack1.getItemDamage();
                    int type = dmg < 128 ? 0 : (dmg < 256 ? 1 : 2);
                    
                    if (type > 2 || parts[type] != null)
                    	return false;
                    else
                    	parts[type] = itemstack1;
                }
                else
                    return false;
            }
        }

        for (int i = 0; i < parts.length; i++)
        {
        	if (parts[i] == null)
        		return false;
        }
    
        return true;
    }

    public ItemStack getCraftingResult(InventoryCrafting par1InventoryCrafting)
    {
        ItemStack[] parts = new ItemStack[3];

        for (int j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
        {
            ItemStack itemstack1 = par1InventoryCrafting.getStackInSlot(j);

            if (itemstack1 != null)
            {
                if (itemstack1.itemID == PlaneFighter.itemPlaneFighterPart.itemID)
                {
                    int dmg = itemstack1.getItemDamage();
                    int type = dmg < 128 ? 0 : (dmg < 256 ? 1 : 2);
                    
                    if (type > 2 || parts[type] != null)
                    	return null;
                    else
                    	parts[type] = itemstack1;
                }
                else
                    return null;
            }
        }

        for (int i = 0; i < parts.length; i++)
        {
        	if (parts[i] == null)
        		return null;        	
        }

        ItemStack stack = new ItemStack(PlaneFighter.itemPlaneFighter);
    	stack.setTagInfo("planeBodyType", new NBTTagByte("planeBodyType", (byte)parts[0].getItemDamage()));
    	stack.setTagInfo("planeWingType", new NBTTagByte("planeWingType", (byte)(parts[1].getItemDamage() - 128)));
    	stack.setTagInfo("planeWeaponType", new NBTTagByte("planeWeaponType", (byte)(parts[2].getItemDamage() - 256)));

        return stack;
    }

    public int getRecipeSize()
    {
        return 9;
    }

    public ItemStack getRecipeOutput()
    {
        return null;
    }
}
