package net.cc.galacticinvadersmod.entity.client;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.cc.galacticinvadersmod.entity.animations.ModAnimationDefinitions;
import net.cc.galacticinvadersmod.entity.custom.SmallRiftEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class SmallRiftModel<T extends SmallRiftEntity> extends HierarchicalModel<T> {
	private final ModelPart Body;
	private final ModelPart eyes;
	private final ModelPart top;
	private final ModelPart center;
	private final ModelPart bottom;

	public SmallRiftModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.eyes = Body.getChild("eyes");
		this.top = eyes.getChild("top");
		this.center = eyes.getChild("center");
		this.bottom = eyes.getChild("bottom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -34.0F, 0.0F, 16.0F, 34.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(8.0F, -30.0F, 0.0F, 4.0F, 26.0F, 0.0F, new CubeDeformation(0.001F))
		.texOffs(32, 0).addBox(-12.0F, -30.0F, 0.0F, 4.0F, 26.0F, 0.0F, new CubeDeformation(0.001F))
		.texOffs(0, 0).addBox(-22.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 34).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.75F, 0.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(-8.0F, -31.25F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 34).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.75F, 0.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(-8.0F, -2.75F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 40).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.75F, 0.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(8.0F, -31.25F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r4 = Body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 34).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 5.75F, 0.0F, new CubeDeformation(0.002F)), PartPose.offsetAndRotation(8.0F, -2.75F, 0.0F, 0.0F, 0.0F, -2.3562F));

		PartDefinition eyes = Body.addOrReplaceChild("eyes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition top = eyes.addOrReplaceChild("top", CubeListBuilder.create().texOffs(16, 42).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, -28.5F, 0.0F));

		PartDefinition center = eyes.addOrReplaceChild("center", CubeListBuilder.create().texOffs(16, 40).addBox(-1.0F, -18.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bottom = eyes.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(16, 43).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, -5.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(SmallRiftEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.SMALL_RIFT_IDLE, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationDefinitions.SMALL_RIFT_IDLE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Body;
	}
}