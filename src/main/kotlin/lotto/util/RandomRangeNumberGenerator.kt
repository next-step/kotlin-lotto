package lotto.util

object RandomRangeNumberGenerator : NumberGenerator {

    override fun generate(min: Int, max: Int, count: Int): List<Int> {
        return (min..max)
            .toList()
            .shuffled()
            .take(count)
            .sorted()
    }
}
