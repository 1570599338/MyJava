package com.lquan.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {
	public static void trackUseCases(List<Integer> useCase,Class<?> cl) {
		for(Method m:cl.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if (uc !=null) {
				System.out.println("Found Use Case:" + uc.id() + ""+ uc.description());
			}
			useCase.remove(new Integer(uc.id()));
		}
		for(int i:useCase) {
			System.out.println("Warning Missing use case=" + i);
		}
	}
	
	
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<>();
		Collections.addAll(useCases,47,48,49,50);
		trackUseCases(useCases, PasswordUtils.class);
	}

}
