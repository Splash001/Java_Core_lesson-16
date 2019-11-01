package ua.lviv.lgs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Application {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class parent = Parent.class;
		
		String nameOfClass = parent.getName();
		System.out.println("Name of class = " + nameOfClass);
		
		System.out.println();
		
		String simpleName = parent.getSimpleName();
		System.out.println("Simple name of class = " + simpleName);
		
		System.out.println();
		
		int modifier = parent.getModifiers();
		String modifiertext = Modifier.toString(modifier);
		System.out.println("Modifier of class = " + modifier);
		
		System.out.println();
		
		System.out.println("is static = " + Modifier.isStatic(modifier));
		System.out.println("is public = " + Modifier.isPublic(modifier));
		System.out.println("is abstract = " + Modifier.isAbstract(modifier));
		
		System.out.println();
		
		Package classPackage = parent.getPackage();
		System.out.println("Package of current class = " + classPackage);
		
		System.out.println();
		
		Class superClass = parent.getSuperclass();
		System.out.println("Superclass = " + superClass);
		
		System.out.println();
		
		Class[] interfaces = parent.getInterfaces();
		System.out.println("Interfaces = " + Arrays.toString(interfaces));
		
		System.out.println();
		
		Constructor<Parent>[] parentConstructor = parent.getConstructors();
		
		for (int i = 0; i < parentConstructor.length; i++) {
			Constructor<Parent> constructor = parentConstructor[i];
			System.out.println("Constructor = " + constructor);
		}
		
		System.out.println("Constructors size = " + parentConstructor.length);
		
		System.out.println();
		
		Constructor<Parent> constructor = parentConstructor[0];
		
		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			Class<?> class1 = parameterTypes[i];
			System.out.println(class1);			
		}
		
		System.out.println();
		
		Constructor<Parent> singleConstructor = parent.getConstructor(String.class, int.class);
		System.out.println("single constructor = " + singleConstructor);
		Parent newInstanceParent = singleConstructor.newInstance("Bill", 33);
		System.out.println("reflection Parent = " + newInstanceParent);
		System.out.println();
		
		Field [] fields = parent.getFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		
		System.out.println();
		
		fields = parent.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			System.out.println(field);
		}
		
		System.out.println();
		
		Field nameField = parent.getField("name");
		nameField.set(newInstanceParent, "Coomet");
		System.out.println("Parent new age = " + newInstanceParent);
		
		Field privateLastNameField= fields[3];
		privateLastNameField.setAccessible(true);
		System.out.println("private value= " + privateLastNameField.get(newInstanceParent));
		
		System.out.println();
		
		Method [] myMethods = parent.getMethods();
		for (int i = 0; i < myMethods.length; i++) {
			Method method = myMethods[i];
			System.out.println(method);
		}
		
		System.out.println();
		
		myMethods[4].invoke(newInstanceParent, "Jannet");
		myMethods[6].invoke(newInstanceParent, 25);
		System.out.println();
		System.out.println(newInstanceParent);
		

	}

}
