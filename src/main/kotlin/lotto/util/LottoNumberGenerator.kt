package lotto.util

object LottoNumberGenerator : NumberGenerator {

    private const val MIN = 1
    private const val MAX = 45

    override fun generate(count: Int): List<Int> {
        return (MIN..MAX)
            .toList()
            .shuffled()
            .take(count)
            .sorted()
    }
}
