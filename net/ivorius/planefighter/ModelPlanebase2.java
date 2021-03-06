// Date: 21-10-2013 13:03:34
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package net.ivorius.planefighter;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlanebase2 extends ModelBase
{
	//fields
	ModelRenderer base1;
	ModelRenderer leftstut1;
	ModelRenderer leftstut2;
	ModelRenderer leftstut3;
	ModelRenderer rightstut1;
	ModelRenderer rightstut2;
	ModelRenderer rightstut3;
	ModelRenderer base2;
	ModelRenderer tailbase1;
	ModelRenderer tailbase2;
	ModelRenderer wingbase;
	ModelRenderer leftwing1;
	ModelRenderer rightwing1;
	ModelRenderer tailwing;
	ModelRenderer leftwing2;
	ModelRenderer rightwing2;
	ModelRenderer wheelleft;
	ModelRenderer wheelright;
	ModelRenderer wheelback;
	ModelRenderer rope;

	public ModelPlanebase2()
	{
		textureWidth = 64;
		textureHeight = 32;

		base1 = new ModelRenderer(this, 0, 0);
		base1.addBox(-1F, 2F, -3F, 2, 1, 7);
		base1.setRotationPoint(0F, 20F, -3F);
		base1.setTextureSize(64, 32);
		base1.mirror = true;
		setRotation(base1, 0F, 0F, 0F);
		leftstut1 = new ModelRenderer(this, 50, 0);
		leftstut1.addBox(1.2F, -0.5F, -2.8F, 1, 3, 1);
		leftstut1.setRotationPoint(0F, 20F, -3F);
		leftstut1.setTextureSize(64, 32);
		leftstut1.mirror = true;
		setRotation(leftstut1, 0F, 0F, 0.3346075F);
		leftstut2 = new ModelRenderer(this, 55, 0);
		leftstut2.addBox(1.2F, -0.5F, 0.2F, 1, 3, 1);
		leftstut2.setRotationPoint(0F, 20F, -3F);
		leftstut2.setTextureSize(64, 32);
		leftstut2.mirror = true;
		setRotation(leftstut2, 0F, 0F, 0.3346145F);
		leftstut3 = new ModelRenderer(this, 50, 5);
		leftstut3.addBox(1.2F, -0.5F, 3.2F, 1, 3, 1);
		leftstut3.setRotationPoint(0F, 20F, -3F);
		leftstut3.setTextureSize(64, 32);
		leftstut3.mirror = true;
		setRotation(leftstut3, 0F, 0F, 0.3346145F);
		rightstut1 = new ModelRenderer(this, 55, 5);
		rightstut1.addBox(-2.2F, -0.5F, -2.8F, 1, 3, 1);
		rightstut1.setRotationPoint(0F, 20F, -3F);
		rightstut1.setTextureSize(64, 32);
		rightstut1.mirror = true;
		setRotation(rightstut1, 0F, 0F, -0.3346145F);
		rightstut2 = new ModelRenderer(this, 50, 10);
		rightstut2.addBox(-2.2F, -0.5F, 0.2F, 1, 3, 1);
		rightstut2.setRotationPoint(0F, 20F, -3F);
		rightstut2.setTextureSize(64, 32);
		rightstut2.mirror = true;
		setRotation(rightstut2, 0F, 0F, -0.3346145F);
		rightstut3 = new ModelRenderer(this, 55, 10);
		rightstut3.addBox(-2.2F, -0.5F, 3.2F, 1, 3, 1);
		rightstut3.setRotationPoint(0F, 20F, -3F);
		rightstut3.setTextureSize(64, 32);
		rightstut3.mirror = true;
		setRotation(rightstut3, 0F, 0F, -0.3346145F);
		base2 = new ModelRenderer(this, 0, 9);
		base2.addBox(-1.5F, 0F, -3F, 3, 1, 8);
		base2.setRotationPoint(0F, 20F, -3F);
		base2.setTextureSize(64, 32);
		base2.mirror = true;
		setRotation(base2, 0F, 0F, 0F);
		tailbase1 = new ModelRenderer(this, 0, 19);
		tailbase1.addBox(-1F, 0F, 5F, 2, 1, 5);
		tailbase1.setRotationPoint(0F, 20F, -3F);
		tailbase1.setTextureSize(64, 32);
		tailbase1.mirror = true;
		setRotation(tailbase1, 0F, 0F, 0F);
		tailbase2 = new ModelRenderer(this, 15, 19);
		tailbase2.addBox(-0.5F, 2.5F, 2F, 1, 1, 8);
		tailbase2.setRotationPoint(0F, 20F, -3F);
		tailbase2.setTextureSize(64, 32);
		tailbase2.mirror = true;
		setRotation(tailbase2, 0.2230717F, 0F, 0F);
		wingbase = new ModelRenderer(this, 34, 19);
		wingbase.addBox(-1F, -0.5F, -2.5F, 2, 1, 7);
		wingbase.setRotationPoint(0F, 20F, -3F);
		wingbase.setTextureSize(64, 32);
		wingbase.mirror = true;
		setRotation(wingbase, -0.1115358F, 0F, 0F);
		leftwing1 = new ModelRenderer(this, 30, 0);
		leftwing1.addBox(3F, 1.5F, 8F, 6, 0, 3);
		leftwing1.setRotationPoint(0F, 20F, -3F);
		leftwing1.setTextureSize(64, 32);
		leftwing1.mirror = true;
		setRotation(leftwing1, 0.1115358F, -0.2602503F, 0F);
		rightwing1 = new ModelRenderer(this, 30, 4);
		rightwing1.addBox(-9F, 1.5F, 8F, 6, 0, 3);
		rightwing1.setRotationPoint(0F, 20F, -3F);
		rightwing1.setTextureSize(64, 32);
		rightwing1.mirror = true;
		setRotation(rightwing1, 0.111544F, 0.260246F, 0F);
		tailwing = new ModelRenderer(this, 30, 5);
		tailwing.addBox(0F, -11F, 5F, 0, 6, 3);
		tailwing.setRotationPoint(0F, 20F, -3F);
		tailwing.setTextureSize(64, 32);
		tailwing.mirror = true;
		setRotation(tailwing, -0.8179294F, 0F, 0F);
		leftwing2 = new ModelRenderer(this, 34, 8);
		leftwing2.addBox(1.8F, 0F, 5F, 4, 0, 3);
		leftwing2.setRotationPoint(0F, 20F, -3F);
		leftwing2.setTextureSize(64, 32);
		leftwing2.mirror = true;
		setRotation(leftwing2, -0.0743572F, -0.1858931F, 0F);
		rightwing2 = new ModelRenderer(this, 34, 12);
		rightwing2.addBox(-5.8F, 0F, 5F, 4, 0, 3);
		rightwing2.setRotationPoint(0F, 20F, -3F);
		rightwing2.setTextureSize(64, 32);
		rightwing2.mirror = true;
		setRotation(rightwing2, -0.0743572F, 0.185895F, 0F);
		wheelleft = new ModelRenderer(this, 55, 16);
		wheelleft.addBox(-1F, 2F, -4.5F, 1, 1, 3);
		wheelleft.setRotationPoint(0F, 20F, -3F);
		wheelleft.setTextureSize(64, 32);
		wheelleft.mirror = true;
		setRotation(wheelleft, 0.2974289F, -1.152537F, 0F);
		wheelright = new ModelRenderer(this, 46, 16);
		wheelright.addBox(0F, 2F, -4.5F, 1, 1, 3);
		wheelright.setRotationPoint(0F, 20F, -3F);
		wheelright.setTextureSize(64, 32);
		wheelright.mirror = true;
		setRotation(wheelright, 0.2974289F, 1.152546F, 0F);
		wheelback = new ModelRenderer(this, 53, 21);
		wheelback.addBox(-0.5F, 1F, 3F, 1, 1, 4);
		wheelback.setRotationPoint(0F, 20F, -3F);
		wheelback.setTextureSize(64, 32);
		wheelback.mirror = true;
		setRotation(wheelback, -0.3717861F, 0F, 0F);
		rope = new ModelRenderer(this, 18, 0);
		rope.addBox(-0.5F, 0F, 1F, 1, 0, 9);
		rope.setRotationPoint(0F, 20F, -3F);
		rope.setTextureSize(64, 32);
		rope.mirror = true;
		setRotation(rope, 0.1858931F, 0F, 0F);
	}

	public void render( Entity entity, float f, float f1, float f2, float f3, float f4, float f5 )
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		base1.render(f5);
		leftstut1.render(f5);
		leftstut2.render(f5);
		leftstut3.render(f5);
		rightstut1.render(f5);
		rightstut2.render(f5);
		rightstut3.render(f5);
		base2.render(f5);
		tailbase1.render(f5);
		tailbase2.render(f5);
		wingbase.render(f5);
		leftwing1.render(f5);
		rightwing1.render(f5);
		tailwing.render(f5);
		leftwing2.render(f5);
		rightwing2.render(f5);
		wheelleft.render(f5);
		wheelright.render(f5);
		wheelback.render(f5);
		rope.render(f5);
	}

	private void setRotation( ModelRenderer model, float x, float y, float z )
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
