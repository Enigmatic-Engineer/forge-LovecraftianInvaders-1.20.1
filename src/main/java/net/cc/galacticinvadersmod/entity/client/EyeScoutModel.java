package net.cc.galacticinvadersmod.entity.client;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.cc.galacticinvadersmod.entity.animations.ModAnimationDefinitions;
import net.cc.galacticinvadersmod.entity.custom.EyeScoutEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class EyeScoutModel<T extends EyeScoutEntity> extends HierarchicalModel<T> {
	private final ModelPart eye_scout_body;
	private final ModelPart eye_scout_head;
	private final ModelPart antenna;
	private final ModelPart eye_scout_tentacles;
	private final ModelPart front_tentacle;
	private final ModelPart front_tentacle_lower;
	private final ModelPart back_left_tentacle;
	private final ModelPart back_left_tentacle_lower;
	private final ModelPart back_right_tentacle;
	private final ModelPart back_right_tentacle_lower;

	public EyeScoutModel(ModelPart root) {
		this.eye_scout_body = root.getChild("eye_scout_body");
		this.eye_scout_head = eye_scout_body.getChild("eye_scout_head");
		this.antenna = eye_scout_body.getChild("eye_scout_head").getChild("antenna");
		this.eye_scout_tentacles = eye_scout_body.getChild("eye_scout_head").getChild("eye_scout_tentacles");
		this.front_tentacle = eye_scout_body.getChild("eye_scout_head").getChild("eye_scout_tentacles").getChild("front_tentacle");
		this.front_tentacle_lower = eye_scout_body.getChild("eye_scout_head").getChild("eye_scout_tentacles").getChild("front_tentacle").getChild("front_tentacle_lower");
		this.back_left_tentacle = eye_scout_body.getChild("eye_scout_head").getChild("eye_scout_tentacles").getChild("back_left_tentacle");
		this.back_left_tentacle_lower = eye_scout_body.getChild("eye_scout_head").getChild("eye_scout_tentacles").getChild("back_left_tentacle").getChild("back_left_tentacle_lower");
		this.back_right_tentacle = eye_scout_body.getChild("eye_scout_head").getChild("eye_scout_tentacles").getChild("back_right_tentacle");
		this.back_right_tentacle_lower = eye_scout_body.getChild("eye_scout_head").getChild("eye_scout_tentacles").getChild("back_right_tentacle").getChild("back_right_tentacle_lower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition eye_scout_body = partdefinition.addOrReplaceChild("eye_scout_body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition eye_scout_head = eye_scout_body.addOrReplaceChild("eye_scout_head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -1.9938F, -1.6862F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-1.0F, -0.9938F, -2.4962F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(15, 15).addBox(-1.5F, -1.4938F, -2.1862F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0062F, -0.3138F));

		PartDefinition cube_r1 = eye_scout_head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 12).addBox(-1.5F, -3.5F, -2.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2438F, 2.3138F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r2 = eye_scout_head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 8).addBox(-1.5F, -3.5F, -2.3F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0062F, 0.3138F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition cube_r3 = eye_scout_head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 8).addBox(-1.5F, -3.5F, -2.3F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0062F, 0.3138F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r4 = eye_scout_head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 12).addBox(-1.5F, -3.5F, -2.3F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0062F, 0.3138F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r5 = eye_scout_head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 0).addBox(-1.5F, -3.5F, -2.3F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0062F, 0.3138F, 0.0F, 1.5708F, 0.0F));

		PartDefinition antenna = eye_scout_head.addOrReplaceChild("antenna", CubeListBuilder.create().texOffs(4, 19).addBox(0.5F, -12.5F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F))
		.texOffs(0, 19).addBox(0.5F, -11.75F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(0, 22).addBox(0.5F, -12.5F, 0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(-0.45F))
		.texOffs(4, 22).addBox(0.5F, -13.25F, 0.5F, 1.0F, 0.0F, 1.0F, new CubeDeformation(-0.48F)), PartPose.offset(0.0F, 9.0062F, 0.3138F));

		PartDefinition eye_scout_tentacles = eye_scout_head.addOrReplaceChild("eye_scout_tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0062F, 0.3138F));

		PartDefinition front_tentacle = eye_scout_tentacles.addOrReplaceChild("front_tentacle", CubeListBuilder.create().texOffs(20, 0).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -1.25F));

		PartDefinition cube_r6 = front_tentacle.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 19).addBox(-0.5F, -0.2008F, -0.487F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition front_tentacle_lower = front_tentacle.addOrReplaceChild("front_tentacle_lower", CubeListBuilder.create(), PartPose.offset(0.0F, 3.6514F, 0.5286F));

		PartDefinition cube_r7 = front_tentacle_lower.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(6, 16).addBox(-0.5F, -0.4036F, -0.5452F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 2.3486F, 1.7214F, 1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r8 = front_tentacle_lower.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(10, 16).addBox(-0.5F, -0.4555F, -0.4197F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.5486F, 0.7714F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r9 = front_tentacle_lower.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(20, 19).addBox(-0.5F, -0.326F, -0.4675F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0986F, -0.0286F, 0.5236F, 0.0F, 0.0F));

		PartDefinition back_left_tentacle = eye_scout_tentacles.addOrReplaceChild("back_left_tentacle", CubeListBuilder.create().texOffs(20, 9).addBox(-0.5F, 0.0021F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.25F, -7.5F, 1.25F));

		PartDefinition cube_r10 = back_left_tentacle.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(20, 6).addBox(-0.5F, -0.2008F, -0.487F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 2.0021F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition back_left_tentacle_lower = back_left_tentacle.addOrReplaceChild("back_left_tentacle_lower", CubeListBuilder.create(), PartPose.offset(0.0F, 3.6535F, 0.5286F));

		PartDefinition cube_r11 = back_left_tentacle_lower.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(16, 4).addBox(-0.5F, -0.4036F, -0.5452F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 2.3486F, 1.7214F, 1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r12 = back_left_tentacle_lower.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 10).addBox(-0.5F, -0.4555F, -0.4197F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.5486F, 0.7714F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r13 = back_left_tentacle_lower.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(20, 3).addBox(-0.5F, -0.326F, -0.4675F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0986F, -0.0286F, 0.5236F, 0.0F, 0.0F));

		PartDefinition back_right_tentacle = eye_scout_tentacles.addOrReplaceChild("back_right_tentacle", CubeListBuilder.create().texOffs(19, 12).addBox(-0.5F, 0.0014F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.25F, -7.5F, 1.25F));

		PartDefinition cube_r14 = back_right_tentacle.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(12, 19).addBox(-0.5F, -0.2008F, -0.487F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.0F, 2.0014F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition back_right_tentacle_lower = back_right_tentacle.addOrReplaceChild("back_right_tentacle_lower", CubeListBuilder.create(), PartPose.offset(0.0F, 3.6529F, 0.5286F));

		PartDefinition cube_r15 = back_right_tentacle_lower.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.4036F, -0.5452F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 2.3486F, 1.7214F, 1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r16 = back_right_tentacle_lower.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(16, 7).addBox(-0.5F, -0.4555F, -0.4197F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.5486F, 0.7714F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r17 = back_right_tentacle_lower.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(8, 19).addBox(-0.5F, -0.326F, -0.4675F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0986F, -0.0286F, 0.5236F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(EyeScoutEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(ModAnimationDefinitions.EYE_SCOUT_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(entity.idleAnimationState, ModAnimationDefinitions.EYE_SCOUT_IDLE, ageInTicks, 1f);
		this.animate(entity.attackAnimationState, ModAnimationDefinitions.EYE_SCOUT_ATTACK, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		eye_scout_body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return eye_scout_body;
	}
}