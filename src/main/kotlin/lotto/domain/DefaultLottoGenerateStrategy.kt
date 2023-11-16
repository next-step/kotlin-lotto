package lotto.domain

class DefaultLottoGenerateStrategy : LottoGenerateStrategy {
    private val numberPool: IntRange = Lotto.MIN_NUMBER..Lotto.MAX_NUMBER
    override fun generate(): Lotto {
        val numbers = numberPool
            .shuffled()
            .subList(0, Lotto.NUMBERS_COUNT)
            .sorted()

        return Lotto(numbers)
    }
}
