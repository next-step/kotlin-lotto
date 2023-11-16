package lotto.domain

class DefaultLottoGenerateStrategy : LottoGenerateStrategy {
    private val numberPool: IntRange = Lotto.MIN_NUMBER..Lotto.MAX_NUMBER
    override fun generate(): Lotto {
        val numbers = numberPool.shuffled()

        val winningNumbers = numbers
            .subList(0, Lotto.NUMBERS_COUNT)
            .sorted()

        val bonusNumber = numbers[Lotto.NUMBERS_COUNT]

        return Lotto(winningNumbers, bonusNumber)
    }
}
