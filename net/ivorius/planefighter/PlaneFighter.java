package net.ivorius.planefighter;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "MiniIvPlaneFighter", name = "Mini: Plane Fighter", version = "1.0")
@NetworkMod(clientSideRequired = true)
public class PlaneFighter
{

	@Instance(value = "MiniIvPlaneFighter")
	public static PlaneFighter instance;

	public static Item itemPlaneFighterPart;
	public static Item itemPlaneFighter;

	@SidedProxy(clientSide = "net.ivorius.planefighter.client.ClientProxy", serverSide = "net.ivorius.planefighter.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit( FMLPreInitializationEvent event )
	{
		itemPlaneFighterPart = new ItemPlaneFighterPart(12000).setUnlocalizedName("planefighterPart").setCreativeTab(CreativeTabs.tabTransport);
		itemPlaneFighter = new ItemPlaneFighter(12001).setUnlocalizedName("planefighter").setCreativeTab(CreativeTabs.tabTransport);
	}

	@EventHandler
	public void load( FMLInitializationEvent event )
	{
		proxy.registerRenderers();
	
        LanguageRegistry.addName(itemPlaneFighterPart, "Generic Plane Fighter Part");
        for (int body = 0; body < ItemPlaneFighterPart.bodyNames.length; body++)
            LanguageRegistry.addName(new ItemStack(itemPlaneFighterPart, 1, body), ItemPlaneFighterPart.bodyNames[body]);        	
        for (int wing = 0; wing < ItemPlaneFighterPart.wingNames.length; wing++)
            LanguageRegistry.addName(new ItemStack(itemPlaneFighterPart, 1, wing + 128), ItemPlaneFighterPart.wingNames[wing]);        	
        for (int weapon = 0; weapon < ItemPlaneFighterPart.weaponNames.length; weapon++)
            LanguageRegistry.addName(new ItemStack(itemPlaneFighterPart, 1, weapon + 256), ItemPlaneFighterPart.weaponNames[weapon]);

        LanguageRegistry.addName(new ItemStack(itemPlaneFighter), "Plane Fighter");

        GameRegistry.addRecipe(new RecipePlanefighter());
        
        GameRegistry.addRecipe(new ItemStack(itemPlaneFighterPart, 1, 0), new Object[] {
        	"P#P",
        	"IOI",
        	"GTG",
        	'P', Item.paper, '#', Block.planks, 'I', Item.stick, 'O', Item.enderPearl, 'G', Item.ingotIron, 'T', Block.torchRedstoneActive
        });
        GameRegistry.addRecipe(new ItemStack(itemPlaneFighterPart, 1, 1), new Object[] {
        	"P#P",
        	"IOI",
        	"T#T",
        	'P', Item.paper, '#', Block.planks, 'I', Item.stick, 'O', Item.enderPearl, 'G', Item.ingotIron, 'T', Block.torchRedstoneActive
        });

        GameRegistry.addRecipe(new ItemStack(itemPlaneFighterPart, 1, 128), new Object[] {
        	"PPI",
        	" II",
        	"PPI",
        	'P', Item.paper, '#', Block.planks, 'I', Item.stick, 'O', Item.enderPearl, 'G', Item.ingotIron, 'T', Block.torchRedstoneActive
        });
        GameRegistry.addRecipe(new ItemStack(itemPlaneFighterPart, 1, 128 + 1), new Object[] {
        	"PIP",
        	" IP",
        	"PIP",
        	'P', Item.paper, '#', Block.planks, 'I', Item.stick, 'O', Item.enderPearl, 'G', Item.ingotIron, 'T', Block.torchRedstoneActive
        });

        GameRegistry.addRecipe(new ItemStack(itemPlaneFighterPart, 1, 256), new Object[] {
        	"GFG",
        	"C C",
        	'G', Item.ingotIron, 'F', Item.flintAndSteel, 'C', Item.gunpowder
        });
        GameRegistry.addRecipe(new ItemStack(itemPlaneFighterPart, 1, 256 + 1), new Object[] {
        	" F ",
        	"GCG",
        	" G ",
        	'G', Item.ingotIron, 'F', Item.flintAndSteel, 'C', Item.gunpowder
        });

        int entityID = 0;
        EntityRegistry.registerModEntity(EntityPlaneFighter.class, "PlaneFighter", entityID, this, 80, 1, true);
        entityID ++;
	}

	@EventHandler
	public void postInit( FMLPostInitializationEvent event )
	{
		
	}
}
