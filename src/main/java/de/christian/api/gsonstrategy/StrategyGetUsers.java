package de.christian.api.gsonstrategy;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import de.christian.api.model.Article;
import de.christian.api.model.Role;
import de.christian.api.model.Tag;
import de.christian.api.model.User;

public class StrategyGetUsers implements ExclusionStrategy {
	public boolean shouldSkipClass(Class<?> arg0) {
		return false;
	}

	public boolean shouldSkipField(FieldAttributes f) {

		if (f.getDeclaringClass() == User.class && (f.getName().equals("news") || f.getName().equals("projects"))) {
			return true;
		} else if (f.getDeclaringClass() == Role.class && (f.getName().equals("user"))) {
			return true;
		}
		return false;
	}
}
