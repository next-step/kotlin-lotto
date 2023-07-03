package lotto.domain

class RandomLottoNumberGenerationStrategy : LottoNumberGenerationStrategy {

    private var lottoNumberList = LottoNumber.generateLottoNumberList()
    override fun generateLottoNumber(): List<LottoNumber> {
        return lottoNumberList.shuffled().take(LotteryPaper.NUMBER_OF_LOTTO_DRAWS)
    }
}
