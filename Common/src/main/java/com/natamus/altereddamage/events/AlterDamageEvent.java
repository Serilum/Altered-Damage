package com.natamus.altereddamage.events;

import com.natamus.altereddamage.config.ConfigHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class AlterDamageEvent {
	public static float onEntityDamageTaken(Level world, Entity target, DamageSource damageSource, float originalDamage) {
		double modifier;
		if (target instanceof Player) {
			if (!ConfigHandler.alterPlayerDamageTaken) {
				return originalDamage;
			}
			
			modifier = ConfigHandler.playerDamageModifier;
		}
		else {
			if (!ConfigHandler.alterEntityDamageTaken) {
				return originalDamage;
			}
			
			modifier = ConfigHandler.entityDamageModifier;
		}
		
		float damage = (float)(originalDamage*modifier);
		
		if (ConfigHandler.preventFatalModifiedDamage) {
			LivingEntity le = (LivingEntity)target;
			float health = le.getHealth();
			if (damage >= health && originalDamage < health) {
				return health-0.1F;
			}
		}
		
		return damage;
	}
}
