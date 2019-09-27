package com.junit.tc.processor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import com.junit.tc.processor.Constants;


public class JunitTestCaseCreator {
	/*https://www.journaldev.com/1789/java-reflection-example-tutorial*/
	
	
public static void main(String[] args) throws SecurityException, ClassNotFoundException {
	 String className="com.junit.tc.processor.Car";
	 
	 // get All public declared method a java class
	 Method[] publicMethods = Class.forName(className).getDeclaredMethods();
	 //prints public methods of ConcreteClass, BaseClass, Object
	 System.out.println("public methods : "+ Arrays.toString(publicMethods));
	 String imports = dojUnitImports();
	 String testClass = "public class CarTest";
     //Create Test Method for for each public method
	 System.out.println("imports : "+imports);
	 System.out.println("testClass : "+testClass);
	 List<Method> methodList = Arrays.asList(publicMethods);
	 for(Method method: methodList) {
		 //create a test Method
		 String testMethod = createTestMethod(className,method,method.getName());
		 System.out.println("testMethodName : "+testMethod);
	 }
	 
   }

	private static String dojUnitImports() {
		StringBuffer imports = new StringBuffer();
		imports.append("import org.junit.*;\n");
		imports.append("import com.junit.tc.processor.Car;\n");
		return imports.toString();
	}

	private static String createTestMethod(String className, Method method, String methodName) {
		String testMethodName = "test"+methodName;
		String testMethodSign="@Test public void "+testMethodName+"() { "
				+ "  } ";
		return testMethodSign;
	}
	
	private String addBlock(String blockType, String block) {
		switch(blockType) {
			case Constants.SMALL :
			   if(block == "START") {
				   return "\n(\n";
			   } else if (block == "END") {
				   return "\n)\n";
			   }
			case Constants.LARGE :
				if(block == "START") {
					   return "\n[\n";
				   } else if (block == "END") {
					   return "\n]\n";
				   }
			case Constants.CURLY :
				if(block == "START") {
					   return "\n{\n";
				   } else if (block == "END") {
					   return "\n}\n";
				   }
			  
		}
		
		return null;
		
	}
	
}

