package lotto.domain

class RandomLottoNumberGenerationStrategy : LottoNumberGenerationStrategy {

    private var lottoNumberPool: List<LottoNumber> = LottoNumber.generateLottoNumberList()
    override fun generateLottoNumber(): List<LottoNumber> {
        return lottoNumberPool.shuffled().take(LotteryPaper.NUMBER_OF_LOTTO_DRAWS)
    }
}
