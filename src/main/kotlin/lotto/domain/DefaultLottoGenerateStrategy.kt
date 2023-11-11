package lotto.domain

class DefaultLottoGenerateStrategy : LottoGenerateStrategy {
    private val numberPool: IntRange = Lotto.MIN_NUMBER..Lotto.MAX_NUMBER
    override fun generate(): List<Int> {
        return numberPool
            .shuffled()
            .subList(0, Lotto.NUMBERS_COUNT)
            .sorted()
    }
}
