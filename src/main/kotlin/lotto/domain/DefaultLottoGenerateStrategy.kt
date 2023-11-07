package lotto.domain

private const val LOTTO_MINIMUM_NUMBER = 1
private const val LOTTO_MAXIMUM_NUMBER = 45
private const val LOTTO_NUMBER_COUNT = 6

class DefaultLottoGenerateStrategy : LottoGenerateStrategy {
    private val numberPool: IntRange = LOTTO_MINIMUM_NUMBER..LOTTO_MAXIMUM_NUMBER
    override fun generate(): List<Int> {
        return numberPool
            .shuffled()
            .subList(0, LOTTO_NUMBER_COUNT)
            .sorted()
    }
}
