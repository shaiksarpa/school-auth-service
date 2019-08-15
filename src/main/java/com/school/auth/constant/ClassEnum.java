package com.school.auth.constant;

import java.util.Arrays;
import java.util.List;

public enum ClassEnum {

	BABY, LKG, UKG, I, II, III, IV, V, VI, VII, VIII, IX, X;
	
	public static List<ClassEnum> list() {
		return Arrays.asList(values());
	}
}
