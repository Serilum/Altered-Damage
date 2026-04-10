package com.natamus.altereddamage.forge.events;

import com.natamus.altereddamage.events.AlterDamageEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeAlterDamageEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeAlterDamageEvent.class);

		LivingHurtEvent.BUS.addListener(ForgeAlterDamageEvent::onEntityDamageTaken);
	}

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
