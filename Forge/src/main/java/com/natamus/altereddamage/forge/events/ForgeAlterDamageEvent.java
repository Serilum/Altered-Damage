package com.natamus.altereddamage.forge.events;

import com.natamus.altereddamage.events.AlterDamageEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeAlterDamageEvent {
	@SubscribeEvent
	public void onEntityDamageTaken(LivingHurtEvent e) {
		LivingEntity livingEntity = e.getEntity();

		float originalDamage = e.getAmount();
		float newDamage = AlterDamageEvent.onEntityDamageTaken(livingEntity.level, livingEntity, e.getSource(), originalDamage);

		if (originalDamage != newDamage) {
			e.setAmount(newDamage);
		}
	}
}
