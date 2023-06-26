package lotto.domain

class RandomLottoNumberGenerationStrategy : LottoNumberGenerationStrategy {
    override fun generateLottoNumber(): List<Int> {
        return (LotteryPaper.MINIMUM_NUMBER..LotteryPaper.MAXIMUM_NUMBER)
            .shuffled()
            .take(LotteryPaper.NUMBER_OF_LOTTO_DRAWS)
    }
}
