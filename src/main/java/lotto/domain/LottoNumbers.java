package lotto.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {

    private final Set<LottoNumber> numbers;

    public LottoNumbers(Collection<LottoNumber> numbers) {
        this.numbers = Collections.unmodifiableSet(new TreeSet<>(numbers));
        validateNumbersSizeAndDuplicateNumbers();
    }

    public static LottoNumbers of(List<Integer> numbers) {
        return new LottoNumbers(numbers.stream()
                                       .map(LottoNumber::of)
                                       .collect(toList()));
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public int getMatchCount(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers.getNumbers()
                                 .stream()
                                 .filter(this.numbers::contains)
                                 .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    private void validateNumbersSizeAndDuplicateNumbers() {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복 없는 6개의 수를 사용해야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
