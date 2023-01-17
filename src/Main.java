import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> list = List.of(1, 3, 4, 7, 9);
        Stream stream = list.stream();
        Comparator order = Comparator.naturalOrder();
        BiConsumer BiConsumer = new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
            }
        };
        findMinMax(stream, order, BiConsumer);
        List<Integer> listOfNums = List.of(1, 2, 3, 5, 6, 7, 8, 9, 10);
        countPrint(listOfNums);


    }

    public static void countPrint(List<Integer> list) {

        int count = (int) list.stream().filter(e -> e % 2 == 0).count();
        System.out.println(count);

        list.stream().filter(e -> e % 2 == 0).forEach(System.out::println);
    }

    public static void findMinMax(Stream stream,
                                  Comparator order,
                                  BiConsumer minMaxConsumer) {
        var min = Stream.of(stream).min(order).get();
        var max = Stream.of(stream).max(order).get();
        if (stream == Stream.empty()) {
            minMaxConsumer.accept(null, null);
        }
        minMaxConsumer.accept(min, max);
    }

}