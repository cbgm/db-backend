package de.christian.api.gsonstrategy;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import de.christian.api.model.Image;
import de.christian.api.model.Tag;

public class StrategyGetImages implements ExclusionStrategy {
	public boolean shouldSkipClass(Class<?> arg0) {
		return false;
	}

	public boolean shouldSkipField(FieldAttributes f) {

		if (f.getDeclaringClass() == Image.class && (f.getName().equals("galleries"))) {
			return true;
		}
		return false;
	}
}
