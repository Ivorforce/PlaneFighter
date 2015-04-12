package net.ivorius.planefighter;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPlaneFighter extends RenderLiving
{
	public ModelBase[] bodyModels = new ModelBase[2];
	public ResourceLocation[] bodyTextures = new ResourceLocation[2];
	public ModelBase[] wingModels = new ModelBase[2];
	public ResourceLocation[] wingTextures = new ResourceLocation[2];
	public ModelBase[] weaponModels = new ModelBase[2];
	public ResourceLocation[] weaponTextures = new ResourceLocation[2];

	public RenderPlaneFighter(float par2)
	{
		super(new ModelPlanebase1(), par2);

		this.bodyModels[0] = this.mainModel;
		this.bodyModels[1] = new ModelPlanebase2();
		this.wingModels[0] = new ModelPlanewings1();
		this.wingModels[1] = new ModelPlanewings2();
		this.weaponModels[0] = new ModelPlaneguns1();
		this.weaponModels[1] = new ModelPlaneguns2();

		for (int i = 0; i < bodyModels.length; i++)
			this.bodyTextures[i] = new ResourceLocation("planefighter", "models/Planebase" + (i + 1) + ".png");
		for (int i = 0; i < wingModels.length; i++)
			this.wingTextures[i] = new ResourceLocation("planefighter", "models/Planewings" + (i + 1) + ".png");
		for (int i = 0; i < weaponModels.length; i++)
			this.weaponTextures[i] = new ResourceLocation("planefighter", "models/Planeguns" + (i + 1) + ".png");
	}

	public int renderPlaneFighterPassModel( EntityPlaneFighter entity, int par2, float par3 )
	{
		if (par2 < 2)
		{
            GL11.glEnable(GL11.GL_CULL_FACE);

            if (par2 == 0)
			{
				this.setRenderPassModel(this.wingModels[entity.getWingType()]);
				this.bindTexture(wingTextures[entity.getWingType()]);
			}
			else
			{
				this.setRenderPassModel(this.weaponModels[entity.getWeaponType()]);
				this.bindTexture(weaponTextures[entity.getWeaponType()]);
			}

			return 1;
		}
		else
	        GL11.glDisable(GL11.GL_CULL_FACE);

		return -1;
	}
	
	@Override
	protected void preRenderCallback( EntityLivingBase par1EntityLivingBase, float par2 )
	{
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glRotated(par1EntityLivingBase.rotationPitch, 1.0f, 0.0f, 0.0f);
        GL11.glRotated(((EntityPlaneFighter)par1EntityLivingBase).planeRoll, 0.0f, 0.0f, 1.0f);

        this.mainModel = this.bodyModels[((EntityPlaneFighter)par1EntityLivingBase).getBodyType()];
        
        super.preRenderCallback(par1EntityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture( Entity entity )
	{
		return this.bodyTextures[((EntityPlaneFighter)entity).getBodyType()];
	}

	protected int shouldRenderPass( EntityLivingBase par1EntityLivingBase, int par2, float par3 )
	{
		return this.renderPlaneFighterPassModel((EntityPlaneFighter) par1EntityLivingBase, par2, par3);
	}

	protected int inheritRenderPass( EntityLivingBase par1EntityLivingBase, int par2, float par3 )
	{
		return -1;
	}
}
