package lotto.domain

class AutoLottoGenerateStrategy : LottoGenerateStrategy {
    private val numberPool: IntRange = LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER
    override fun generate(): Lotto {
        val numbers = numberPool.shuffled()
            .subList(0, Lotto.NUMBERS_COUNT)
            .sorted()

        return Lotto.of(numbers)
    }
}
