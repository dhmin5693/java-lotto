package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Count implements Comparable<Count>{
    public static final Count ZERO = new Count();

    private final int count;

    private Count(){
        this.count = 0;
    }
    private Count(int count) {
        this.count = count;
    }

    public Count increase(){
        return new Count(this.count+1);
    }

    public static Count of(int count){
        if(count == 0){
            return ZERO;
        }

        return new Count(count);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    public BigDecimal toBigDecimal(){
        return BigDecimal.valueOf(count);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }

    @Override
    public int compareTo(Count o)
    {
        return this.count - o.count;
    }
}
