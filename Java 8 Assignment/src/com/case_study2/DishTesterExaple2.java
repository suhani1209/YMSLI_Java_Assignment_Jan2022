package com.case_study2;

import static java.util.stream.Collectors.toList;

import java.nio.MappedByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.case_study2.Dish.Type;


public class DishTesterExaple2 {
	
	public  DishSelectedField getDishSelectedField(Dish d){
		return new DishSelectedField(d.getName(), d.getCalories());
	}
	public static void main(String[] args) {

		List<Dish> allDishes = getAllDishes();
		// Example: return the names of dishes that are low in calories (<400) sorted by number of calories
		List<String> dishesWithLowCalories=
				allDishes
				.stream()
				.filter(d->d.getCalories()<400)
				.map(n->n.getName())
				.collect(Collectors.toList());
		
//		System.out.println(dishesWithLowCalories);
		
		// Getting all veg dishes
		List<String> allVegDishes=
				allDishes
				.stream()
				.filter(d->d.isVegetarian())
				.map(n->n.getName())
				.collect(Collectors.toList());
		
//		System.out.println(allVegDishes);
		
		
		// Get list of All Dishes only containing name and calValue
		List<DishSelectedField> allDisheHavingNameAndCalValue=
				allDishes
				.stream()
				.map(d -> new DishSelectedField(d.getName(),d.getCalories()))
				.collect(Collectors.toList());
				
//		System.out.println(allDisheHavingNameAndCalValue);
		
		
		// create a List by selecting the first three dishes that have more than 300 calories
			List<Dish> first3HavingMoreThan300=
					allDishes
					.stream()
					.sorted(Comparator.comparing(Dish::getCalories))
					.filter(d->d.getCalories()>300)
					.limit(3)
					.collect(Collectors.toList());
			
//			System.out.println(first3HavingMoreThan300);
		
		/*
		 * allMatch, anyMatch,noneMatch, findFirst, findAny
		 */

		// find out whether the menu has a vegetarian option: anyMatch
			boolean hasVeg=
					allDishes
					.stream()
					.anyMatch(d -> d.isVegetarian()==true);
			
//			System.out.println(hasVeg);
			
		
		// find out whether the menu ishealthy :allMatch
		// (ie. all dishes are below 1000 calories):
			boolean ishealthy=
					allDishes
					.stream()
					.allMatch(d -> d.getCalories()>1000);
			
//			System.out.println(ishealthy);
			
		// noneMatch: opposite of allMatch
			boolean ishealthy2=
					allDishes
					.stream()
					.noneMatch(d -> d.getCalories()>1000);
			
//			System.out.println(ishealthy2);

		// Primitive stream specializations
			
		// IntStream,DoubleStream, and LongStream==> avoide boxing cost

		// get all the cal values of all food items
			int totalCal=allDishes.stream()
					.map(d-> d.getCalories())
					.reduce(0,Integer::sum);
			
//			System.out.println(totalCal);
			
		// using primitive stream
		// find max cal values for all dishes, Optional
			OptionalInt val=allDishes.stream()
					.mapToInt(d-> d.getCalories())
					.max();
			
//			System.out.println(val.orElse(-1));
			
		/*
		 * What type of quaries Collect helps:Collectors.groupingBy(..)
		 * ------------------------------------- 
		 * 1. Dishes grouped by type 
		 * 2. Dishes grouped by caloric level 
		 * 3. Dishes grouped by type and then caloric level 
		 * 4. Count dishes in each groups 
		 * 5. Most caloric dishes by type 
		 * 6. Sum calories by type
		 */

			//1. Dishes grouped by type
			Map<Type, List<Dish>> collect = allDishes.stream()
					.collect(Collectors.groupingBy( d-> d.getType()));
			collect.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				entry.getValue().forEach(dish->System.out.println(dish));
			});
			
		//2. Dishes grouped by calorie level
		/*
		 * if (dish.getCalories() <= 400)
				return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700)
				return CaloricLevel.NORMAL;
			else
				return CaloricLevel.FAT;
		 * 
		 */
			Map<Integer, List<Dish>> groupByCalorie = allDishes.stream()
								.collect(Collectors.groupingBy(Dish::getCalories));
			groupByCalorie.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				entry.getValue().forEach(dish->System.out.println(dish));
			});
			
		//3. Dishes grouped by type and then caloric level 
			Map<Type, Map<Integer, List<Dish>>> groupByTypeThenCalorie = allDishes.stream()
			.collect(Collectors.groupingBy(Dish::getType,Collectors.groupingBy(Dish::getCalories)));
			
			groupByTypeThenCalorie.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				entry.getValue().forEach((calorie,dish)->{
					System.out.println(calorie);
					System.out.println(dish);
				});
			});
		
		//4. Count dishes in each groups 
			Map<Type, Long> countDishes = allDishes.stream()
			.collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));
		
			countDishes.entrySet().forEach(entry->{
				System.out.println(entry.getKey()+" : "+entry.getValue());
			});
			
		//5. Most calorie dishes by Type
			Map<Type, Optional<Dish>> mostCalorieByType = allDishes.stream()
			.collect(Collectors.groupingBy(Dish::getType,Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
	
			mostCalorieByType.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				System.out.println(entry.getValue().orElseThrow(RuntimeException::new));
			});
			
		//6. Sum calories by type
			Map<Type, Integer> sum = allDishes.stream()
			.collect(Collectors.groupingBy(Dish::getType,Collectors.summingInt(Dish::getCalories)));
			sum.entrySet().forEach(entry->{
				System.out.println(entry.getKey());
				System.out.println(entry.getValue());
			});
	}

	

	private static List<Dish> getAllDishes() {
		List<Dish> disheds = Arrays.asList(new Dish("pork", false, 800,
				Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish(
						"french fries", true, 530, Dish.Type.OTHER), new Dish(
						"rice", true, 350, Dish.Type.OTHER), new Dish(
						"season fruit", true, 120, Dish.Type.OTHER), new Dish(
						"pizza", true, 550, Dish.Type.OTHER), new Dish(
						"prawns", false, 300, Dish.Type.FISH), new Dish(
						"salmon", false, 450, Dish.Type.FISH));
		return disheds;
	}

}