// Date: 20-10-2013 22:41:28
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package net.ivorius.planefighter;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlanewings1 extends ModelBase
{
	//fields
	ModelRenderer leftbeam1;
	ModelRenderer rightbeam1;
	ModelRenderer leftwing1;
	ModelRenderer leftbeam2;
	ModelRenderer rightbeam2;
	ModelRenderer rightwing1;
	ModelRenderer leftwing2;
	ModelRenderer leftbeam3;
	ModelRenderer rightbeam3;
	ModelRenderer rightwing2;

	public ModelPlanewings1()
	{
		textureWidth = 128;
		textureHeight = 64;

		leftbeam1 = new ModelRenderer(this, 0, 30);
		leftbeam1.addBox(-0.5F, -1F, -1F, 6, 1, 1);
		leftbeam1.setRotationPoint(1F, 20F, -3F);
		leftbeam1.setTextureSize(128, 64);
		leftbeam1.mirror = true;
		setRotation(leftbeam1, 0F, 0.1115358F, -0.0371755F);
		rightbeam1 = new ModelRenderer(this, 15, 30);
		rightbeam1.addBox(-5.5F, -1F, -1F, 6, 1, 1);
		rightbeam1.setRotationPoint(-1F, 20F, -3F);
		rightbeam1.setTextureSize(128, 64);
		rightbeam1.mirror = true;
		setRotation(rightbeam1, 0F, -0.111544F, 0.0371786F);
		leftwing1 = new ModelRenderer(this, 0, 33);
		leftwing1.addBox(-1F, -0.5F, 0F, 7, 0, 4);
		leftwing1.setRotationPoint(1F, 20F, -3F);
		leftwing1.setTextureSize(128, 64);
		leftwing1.mirror = true;
		setRotation(leftwing1, 0F, 0.1115358F, -0.0371786F);
		leftbeam2 = new ModelRenderer(this, 0, 38);
		leftbeam2.addBox(-3F, -1F, 2F, 7, 1, 1);
		leftbeam2.setRotationPoint(1F, 20F, -3F);
		leftbeam2.setTextureSize(128, 64);
		leftbeam2.mirror = true;
		setRotation(leftbeam2, 0F, 0.7807508F, -0.0371786F);
		rightbeam2 = new ModelRenderer(this, 17, 38);
		rightbeam2.addBox(-4F, -1F, 2F, 7, 1, 1);
		rightbeam2.setRotationPoint(-1F, 20F, -3F);
		rightbeam2.setTextureSize(128, 64);
		rightbeam2.mirror = true;
		setRotation(rightbeam2, 0F, -0.7807556F, 0.0371755F);
		rightwing1 = new ModelRenderer(this, 18, 33);
		rightwing1.addBox(-6F, -0.5F, 0F, 7, 0, 4);
		rightwing1.setRotationPoint(-1F, 20F, -3F);
		rightwing1.setTextureSize(128, 64);
		rightwing1.mirror = true;
		setRotation(rightwing1, 0F, -0.111544F, 0.0371755F);
		leftwing2 = new ModelRenderer(this, 0, 41);
		leftwing2.addBox(5F, -1F, -2F, 8, 0, 5);
		leftwing2.setRotationPoint(1F, 20F, -3F);
		leftwing2.setTextureSize(128, 64);
		leftwing2.mirror = true;
		setRotation(leftwing2, 0F, -0.3717861F, 0.1115358F);
		leftbeam3 = new ModelRenderer(this, 0, 47);
		leftbeam3.addBox(4F, -1.5F, -3F, 6, 1, 1);
		leftbeam3.setRotationPoint(1F, 20F, -3F);
		leftbeam3.setTextureSize(128, 64);
		leftbeam3.mirror = true;
		setRotation(leftbeam3, 0F, -0.37179F, 0.111544F);
		rightbeam3 = new ModelRenderer(this, 15, 47);
		rightbeam3.addBox(-10F, -1.5F, -3F, 6, 1, 1);
		rightbeam3.setRotationPoint(-1F, 20F, -3F);
		rightbeam3.setTextureSize(128, 64);
		rightbeam3.mirror = true;
		setRotation(rightbeam3, 0F, 0.37179F, -0.111544F);
		rightwing2 = new ModelRenderer(this, 22, 41);
		rightwing2.addBox(-13F, -1F, -2F, 8, 0, 5);
		rightwing2.setRotationPoint(-1F, 20F, -3F);
		rightwing2.setTextureSize(128, 64);
		rightwing2.mirror = true;
		setRotation(rightwing2, 0F, 0.37179F, -0.111544F);
	}

	public void render( Entity entity, float f, float f1, float f2, float f3, float f4, float f5 )
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		leftbeam1.render(f5);
		rightbeam1.render(f5);
		leftwing1.render(f5);
		leftbeam2.render(f5);
		rightbeam2.render(f5);
		rightwing1.render(f5);
		leftwing2.render(f5);
		leftbeam3.render(f5);
		rightbeam3.render(f5);
		rightwing2.render(f5);
	}

	private void setRotation( ModelRenderer model, float x, float y, float z )
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
