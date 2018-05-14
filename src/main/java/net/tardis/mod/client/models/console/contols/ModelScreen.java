// Date: 3/9/2018 4:14:37 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package net.tardis.mod.client.models.console.contols;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelScreen extends ModelBase {
	// fields
	ModelRenderer frametop;
	ModelRenderer framebottom;
	ModelRenderer frameside0;
	ModelRenderer frameside1;
	ModelRenderer Shape1;
	
	public ModelScreen() {
		textureWidth = 64;
		textureHeight = 32;
		
		frametop = new ModelRenderer(this, 0, 0);
		frametop.addBox(0F, 0F, 0F, 16, 1, 1);
		frametop.setRotationPoint(-8F, 15F, 0F);
		frametop.setTextureSize(64, 32);
		frametop.mirror = true;
		setRotation(frametop, 0F, 0F, 0F);
		framebottom = new ModelRenderer(this, 0, 2);
		framebottom.addBox(0F, 0F, 0F, 16, 1, 1);
		framebottom.setRotationPoint(-8F, 23F, 0F);
		framebottom.setTextureSize(64, 32);
		framebottom.mirror = true;
		setRotation(framebottom, 0F, 0F, 0F);
		frameside0 = new ModelRenderer(this, 4, 7);
		frameside0.addBox(0F, 0F, 0F, 1, 7, 1);
		frameside0.setRotationPoint(7F, 16F, 0F);
		frameside0.setTextureSize(64, 32);
		frameside0.mirror = true;
		setRotation(frameside0, 0F, 0F, 0F);
		frameside1 = new ModelRenderer(this, 8, 4);
		frameside1.addBox(0F, 0F, 0F, 14, 7, 0);
		frameside1.setRotationPoint(-7F, 16F, 1F);
		frameside1.setTextureSize(64, 32);
		frameside1.mirror = true;
		setRotation(frameside1, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 0, 7);
		Shape1.addBox(0F, 0F, 0F, 1, 7, 1);
		Shape1.setRotationPoint(-8F, 16F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f5) {
		super.render(entity, 0, 0, 0, 0, 0, f5);
		setRotationAngles(0, 0, 0, 0, 0, f5, entity);
		frametop.render(f5);
		framebottom.render(f5);
		frameside0.render(f5);
		frameside1.render(f5);
		Shape1.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
}