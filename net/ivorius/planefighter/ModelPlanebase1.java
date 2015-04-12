// Date: 20-10-2013 21:37:06
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package net.ivorius.planefighter;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPlanebase1 extends ModelBase
{
	//fields
	ModelRenderer base1;
	ModelRenderer nose;
	ModelRenderer base2;
	ModelRenderer base3;
	ModelRenderer tailbase1;
	ModelRenderer tailbase2;
	ModelRenderer wingleft;
	ModelRenderer wingright;
	ModelRenderer tailwing;
	ModelRenderer steeringrope;
	ModelRenderer wingstut1;
	ModelRenderer wingstut2;
	ModelRenderer wingstut3;
	ModelRenderer wingstut4;
	ModelRenderer wheelfrontleft;
	ModelRenderer wheelfrontright;
	ModelRenderer wheelback;

	public ModelPlanebase1()
	{
		textureWidth = 64;
		textureHeight = 32;

		base1 = new ModelRenderer(this, 0, 0);
		base1.addBox(-2F, 0F, -2F, 4, 2, 6);
		base1.setRotationPoint(0F, 21F, -3F);
		base1.setTextureSize(64, 32);
		base1.mirror = true;
		setRotation(base1, 0F, 0F, 0F);
		nose = new ModelRenderer(this, 0, 9);
		nose.addBox(-1F, -1F, -4F, 2, 3, 3);
		nose.setRotationPoint(0F, 20F, -3F);
		nose.setTextureSize(64, 32);
		nose.mirror = true;
		setRotation(nose, 0.2230717F, 0F, 0F);
		base2 = new ModelRenderer(this, 0, 16);
		base2.addBox(-1F, -0.75F, -1.2F, 2, 1, 3);
		base2.setRotationPoint(0F, 20F, -3F);
		base2.setTextureSize(64, 32);
		base2.mirror = true;
		setRotation(base2, 0F, 0F, 0F);
		base3 = new ModelRenderer(this, 0, 21);
		base3.addBox(-1F, -0.75F, 1.8F, 2, 2, 4);
		base3.setRotationPoint(0F, 20F, -3F);
		base3.setTextureSize(64, 32);
		base3.mirror = true;
		setRotation(base3, 0F, 0F, 0F);
		tailbase1 = new ModelRenderer(this, 13, 21);
		tailbase1.addBox(-0.5F, 1.25F, 3F, 1, 2, 6);
		tailbase1.setRotationPoint(0F, 20F, -3F);
		tailbase1.setTextureSize(64, 32);
		tailbase1.mirror = true;
		setRotation(tailbase1, 0.1858931F, 0F, 0F);
		tailbase2 = new ModelRenderer(this, 28, 21);
		tailbase2.addBox(-1F, -0.74F, 5.8F, 2, 1, 4);
		tailbase2.setRotationPoint(0F, 20F, -3F);
		tailbase2.setTextureSize(64, 32);
		tailbase2.mirror = true;
		setRotation(tailbase2, 0F, 0F, 0F);
		wingleft = new ModelRenderer(this, 30, 0);
		wingleft.addBox(2F, 0F, 8F, 6, 0, 3);
		wingleft.setRotationPoint(0F, 20F, -3F);
		wingleft.setTextureSize(64, 32);
		wingleft.mirror = true;
		setRotation(wingleft, 0F, -0.2602503F, -0.0743572F);
		wingright = new ModelRenderer(this, 30, 4);
		wingright.addBox(-8F, 0F, 8F, 6, 0, 3);
		wingright.setRotationPoint(0F, 20F, -3F);
		wingright.setTextureSize(64, 32);
		wingright.mirror = true;
		setRotation(wingright, 0F, 0.260246F, 0.074351F);
		tailwing = new ModelRenderer(this, 30, 5);
		tailwing.addBox(0F, -11F, 5F, 0, 5, 3);
		tailwing.setRotationPoint(0F, 20F, -3F);
		tailwing.setTextureSize(64, 32);
		tailwing.mirror = true;
		setRotation(tailwing, -0.7807508F, 0F, 0F);
		steeringrope = new ModelRenderer(this, 30, 8);
		steeringrope.addBox(-0.5F, -0.8F, 0F, 1, 0, 11);
		steeringrope.setRotationPoint(0F, 20F, -3F);
		steeringrope.setTextureSize(64, 32);
		steeringrope.mirror = true;
		setRotation(steeringrope, 0.1858931F, 0F, 0F);
		wingstut1 = new ModelRenderer(this, 55, 0);
		wingstut1.addBox(1.5F, -2F, -1F, 1, 2, 1);
		wingstut1.setRotationPoint(0F, 20F, -3F);
		wingstut1.setTextureSize(64, 32);
		wingstut1.mirror = true;
		setRotation(wingstut1, 0F, 0F, 0.8179294F);
		wingstut2 = new ModelRenderer(this, 55, 4);
		wingstut2.addBox(1.5F, -2F, 1F, 1, 2, 1);
		wingstut2.setRotationPoint(0F, 20F, -3F);
		wingstut2.setTextureSize(64, 32);
		wingstut2.mirror = true;
		setRotation(wingstut2, 0F, 0F, 0.8179294F);
		wingstut3 = new ModelRenderer(this, 55, 8);
		wingstut3.addBox(-2.5F, -2F, -1F, 1, 2, 1);
		wingstut3.setRotationPoint(0F, 20F, -3F);
		wingstut3.setTextureSize(64, 32);
		wingstut3.mirror = true;
		setRotation(wingstut3, 0F, 0F, -0.8179311F);
		wingstut4 = new ModelRenderer(this, 55, 12);
		wingstut4.addBox(-2.5F, -2F, 1F, 1, 2, 1);
		wingstut4.setRotationPoint(0F, 20F, -3F);
		wingstut4.setTextureSize(64, 32);
		wingstut4.mirror = true;
		setRotation(wingstut4, 0F, 0F, -0.8179311F);
		wheelfrontleft = new ModelRenderer(this, 11, 9);
		wheelfrontleft.addBox(0.5F, 2.5F, -3F, 1, 1, 3);
		wheelfrontleft.setRotationPoint(0F, 20F, -3F);
		wheelfrontleft.setTextureSize(64, 32);
		wheelfrontleft.mirror = true;
		setRotation(wheelfrontleft, 0.4089647F, -0.1858931F, 0F);
		wheelfrontright = new ModelRenderer(this, 11, 14);
		wheelfrontright.addBox(-1.5F, 2.5F, -3F, 1, 1, 3);
		wheelfrontright.setRotationPoint(0F, 20F, -3F);
		wheelfrontright.setTextureSize(64, 32);
		wheelfrontright.mirror = true;
		setRotation(wheelfrontright, 0.4089647F, 0.185895F, 0F);
		wheelback = new ModelRenderer(this, 20, 14);
		wheelback.addBox(-0.5F, 0F, 4F, 1, 1, 4);
		wheelback.setRotationPoint(0F, 20F, -3F);
		wheelback.setTextureSize(64, 32);
		wheelback.mirror = true;
		setRotation(wheelback, -0.4461433F, 0F, 0F);
	}

	public void render( Entity entity, float f, float f1, float f2, float f3, float f4, float f5 )
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		base1.render(f5);
		nose.render(f5);
		base2.render(f5);
		base3.render(f5);
		tailbase1.render(f5);
		tailbase2.render(f5);
		wingleft.render(f5);
		wingright.render(f5);
		tailwing.render(f5);
		steeringrope.render(f5);
		wingstut1.render(f5);
		wingstut2.render(f5);
		wingstut3.render(f5);
		wingstut4.render(f5);
		wheelfrontleft.render(f5);
		wheelfrontright.render(f5);
		wheelback.render(f5);
	}

	private void setRotation( ModelRenderer model, float x, float y, float z )
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}