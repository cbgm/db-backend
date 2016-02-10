package de.christian.api.gsonstrategy;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import de.christian.api.model.Image;
import de.christian.api.model.Tag;

public class StrategyGetNews implements ExclusionStrategy {
	public boolean shouldSkipClass(Class<?> arg0) {
		return false;
	}

	public boolean shouldSkipField(FieldAttributes f) {

		if (f.getDeclaringClass() == Tag.class && (f.getName().equals("news") || f.getName().equals("projects") || f.getName().equals("articles"))) {
			return true;
		}
		return false;
	}
}
