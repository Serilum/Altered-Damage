package com.natamus.altereddamage.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.altereddamage.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean preventFatalModifiedDamage = true;
	@Entry public static boolean alterEntityDamageTaken = true;
	@Entry public static boolean alterPlayerDamageTaken = true;
	@Entry(min = 0.01, max = 20.0) public static double entityDamageModifier = 2.0;
	@Entry(min = 0.01, max = 20.0) public static double playerDamageModifier = 2.0;

	public static void initConfig() {
		configMetaData.put("preventFatalModifiedDamage", Arrays.asList(
			"When enabled, does not change the damage output if it would be fatal with the modifier and not fatal without. Prevents dying from for example poison and starvation."
		));
		configMetaData.put("alterEntityDamageTaken", Arrays.asList(
			"If enabled, modifies the damage another entity receives by the global modifier."
		));
		configMetaData.put("alterPlayerDamageTaken", Arrays.asList(
			"If enabled, modifies the damage a player receives by the global modifier."
		));
		configMetaData.put("entityDamageModifier", Arrays.asList(
			"The global damage modifier for other entities."
		));
		configMetaData.put("playerDamageModifier", Arrays.asList(
			"The global damage modifier for players."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}