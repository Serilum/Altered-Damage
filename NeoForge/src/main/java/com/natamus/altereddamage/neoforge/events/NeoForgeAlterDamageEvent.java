package com.natamus.altereddamage.neoforge.events;

import com.natamus.altereddamage.events.AlterDamageEvent;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeAlterDamageEvent {
	@SubscribeEvent
	public static void onEntityDamageTaken(LivingHurtEvent e) {
		LivingEntity livingEntity = e.getEntity();

		float originalDamage = e.getAmount();
		float newDamage = AlterDamageEvent.onEntityDamageTaken(livingEntity.level(), livingEntity, e.getSource(), originalDamage);

		if (originalDamage != newDamage) {
			e.setAmount(newDamage);
		}
	}
}
