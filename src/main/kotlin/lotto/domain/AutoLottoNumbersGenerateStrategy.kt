package lotto.domain

class AutoLottoNumbersGenerateStrategy : LottoNumbersGenerateStrategy {
    private val numberPool: IntRange = LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER
    override fun generate(): LottoNumbers {
        return numberPool
            .shuffled()
            .subList(0, Lotto.NUMBERS_COUNT)
            .sorted()
            .let { LottoNumbers.of(it) }
    }
}
