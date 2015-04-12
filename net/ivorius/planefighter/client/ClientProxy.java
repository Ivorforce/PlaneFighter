package net.ivorius.planefighter.client;

import net.ivorius.planefighter.CommonProxy;
import net.ivorius.planefighter.EntityPlaneFighter;
import net.ivorius.planefighter.RenderPlaneFighter;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
        RenderingRegistry.registerEntityRenderingHandler(EntityPlaneFighter.class, new RenderPlaneFighter(0.5F));
	}
}
