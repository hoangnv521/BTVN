package BTVN_Bai18_java8_hoangnv2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        List<String> listStr = Arrays.asList("helo","Hello","HEllo","HELlo","HELLo","HELLO","HELLO");

        List<Integer> items = Arrays.asList(1,2,3,4,5,6,7);

        // filter
        List<Integer> results = items.stream().filter(i -> {
            return i > 4;
        }).limit(3).collect(Collectors.toList());
        System.out.println("Result : " + results);
         // parallel
        Integer total = items.parallelStream()
                .reduce(0, Integer::sum);

        // sum
        Integer sum = items.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum = "+sum);

        //count
        long total1 = items.stream().count();
        System.out.println("count = "+total1);

        // min , max
        Integer maxNumber = items.stream().max(Comparator.comparing(Integer::valueOf))
                .get();

        Integer minNumber = items.stream().min(Comparator.comparing(Integer::valueOf))
                .get();

        System.out.println("maxNumber = " + maxNumber);
        System.out.println("minNumber = " + minNumber);


        //use parallelStream and map
        Function<List<String>, List<String>> ParaMap = (in) ->{
            return in.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        };
        System.out.println("ParalleStream Map: "+ParaMap.apply(listStr));

        //use parallelStream and reduce
        Function<List<Integer>, Optional> ParaReduce = (in) ->{
            return  in.parallelStream().reduce((a,b) -> (a+b));
        };
        System.out.println("Sum ParalleStream :"+ParaReduce.apply(items));

    }
}
