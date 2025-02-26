package com.springaopdemo;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
// Aspect determines the module to implement
// cross cutting concern
@Component
public class LoggingAspect {

	// advice is the method that implements logging logic
	//@Before("addMethodPointCut()")
	//@After("execution(* add*(..))")
	//this advice will be executed in all the classes starting with method "add"
	//this  logAdvice1 will be executed after these methods gets completed
	/*@After("execution(* add*(..))")
	public void logAdvice1(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		Object[] args = joinPoint.getArgs();
		for (Object signatureArg : args) {
			System.out.println("the args :" + signatureArg + " " + signatureArg.getClass());
		}

		System.out.println("in advice after account dao methods " + method);
	}*/
	
	@After("execution(* add*(..))")
	public void logAdvice1(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		Object[] args = joinPoint.getArgs();
		for (Object signatureArg : args) {
			System.out.println("the args :" + signatureArg + " " + signatureArg.getClass());
		}

		System.out.println("in advice before account dao methods " + method);
	}
	
	
	//this advice gets executed when the method returns a value
		@AfterReturning(pointcut="execution(* getAccounts(..))",returning="result")
		public void logAdvice2(JoinPoint joinPoint,List<String> result) {
			String method = joinPoint.getSignature().toShortString();
			Object[] args = joinPoint.getArgs();
			for (Object signatureArg : args) {
				System.out.println("the args :" + signatureArg + " " + signatureArg.getClass());
			}

			System.out.println("in advice after account return " + method);
			System.out.println("the return result of the method " + result);
		}
	
	

}
