package com.example.exam.validator;
import com.example.exam.annotation.*;
import java.util.*;
import java.lang.reflect.*;

public class Validator {
    public boolean isValid(Object object) {
    	Class<?> cl = object.getClass();
    	Field[] fields = cl.getDeclaredFields();
    	Object value = null;
    	boolean bool = true;

    	for(Field field : fields){
    		field.setAccessible(true);
    		try{
    			value = field.get(object);
    		}catch(IllegalAccessException e){
    			e.getMessage();
    		}

    		if(value !=null && !(value.getClass().isPrimitive()) && field.isAnnotationPresent(NotNull.class)){
    			System.out.println("isPrimitive or not null");
    			bool = true;
    		} else if(field.isAnnotationPresent(NotNull.class)){
    			System.out.println("NotNull is null");
    			bool = false;
    		}
    		if(value != null && Collection.class.isInstance(value) && field.isAnnotationPresent(NotEmpty.class)){
    			Collection col = (Collection) value;
    			if(col != null && col.isEmpty()){
    				bool = false;
    			}
    		} 
    		if(value!=null && field.isAnnotationPresent(Valid.class)){
    			Valid validAnn = field.getAnnotation(Valid.class);
    			double minValue = validAnn.minValue();
    			double maxValue = validAnn.maxValue();
    			double valueDouble = Double.valueOf(value.toString());
    			if(minValue>valueDouble || valueDouble>maxValue){
    				bool = false;
    			}
    			System.out.println(value + " : " + maxValue + " : " + minValue);

    		}

    	}
    	return bool;
	   }
}