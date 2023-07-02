package lotto.domain

class RandomLottoNumberGenerationStrategy : LottoNumberGenerationStrategy {
    override fun generateLottoNumber(): List<LottoNumber> {
        return (LottoNumber.MINIMUM_NUMBER..LottoNumber.MAXIMUM_NUMBER)
            .map { LottoNumber(it) }
            .shuffled()
            .take(LotteryPaper.NUMBER_OF_LOTTO_DRAWS)
    }
}
