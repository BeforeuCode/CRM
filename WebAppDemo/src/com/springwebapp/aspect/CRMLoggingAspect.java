package com.springwebapp.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
		
	
	//setup pointcut declarations
	@Pointcut("execution(* com.springwebapp.controller.*.*(..))")
	private void forControllerPackage() {
		
		
	}
	
	@Pointcut("execution(* com.springwebapp.service.*.*(..))")
	private void forServicePackage() {
		
		
	}
	
	@Pointcut("execution(* com.springwebapp.dao.*.*(..))")
	private void forDaoPackage() {
		
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	//add @Before
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//display the method we are calling and the arguments to the method
		
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling methodL " + theMethod);
		
		//get the args
		Object[] args = theJoinPoint.getArgs();
		
		
		//loop and display
		for(Object tempArg : args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
		
		
		
		
		
	}
	//add @afterreturning
	@AfterReturning(
			pointcut ="forAppFlow()",
			returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		

		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method " + theMethod);
		
		//display data returned
		myLogger.info("==============>> result: " + theResult);
			
		
		
		
	}
	
	
	


}
