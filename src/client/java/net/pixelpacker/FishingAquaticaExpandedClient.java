package net.pixelpacker;

import net.fabricmc.api.ClientModInitializer;
import net.pixelpacker.registers.PredicateRegister;

public class FishingAquaticaExpandedClient implements ClientModInitializer {
	public static final PredicateRegister predicateReg = new PredicateRegister();

	@Override
	public void onInitializeClient() {
		predicateReg.registerPredicates();
	}
}