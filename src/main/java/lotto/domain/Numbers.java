package lotto.domain;

import java.util.List;

public class Numbers {
    private final List<Number> values;

    public Numbers(List<Integer> numbers) {
        this.values = numbers.stream()
                .sorted()
                .map(Number::new)
                .toList();
    }

    public List<Number> getValues() {
        return List.copyOf(values);
    }

}
