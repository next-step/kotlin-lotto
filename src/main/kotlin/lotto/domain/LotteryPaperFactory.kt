package lotto.domain

class LotteryPaperFactory(private val lottoNumberGenerationStrategy: LottoNumberGenerationStrategy) {
    private val lotteryPaperValidator = LotteryPaperValidator()

    fun generateLotteryPaper(lotteryPaperList: List<LotteryPaper>): LotteryPaper {
        var generatedLottoNumber: List<LottoNumber>
        var generatedLotteryPaper: LotteryPaper

        do {
            generatedLottoNumber = lottoNumberGenerationStrategy.generateLottoNumber()
            generatedLotteryPaper = LotteryPaper(generatedLottoNumber)
        } while (lotteryPaperValidator.isAlreadyExistLotteryPaper(lotteryPaperList, generatedLotteryPaper))

        return generatedLotteryPaper
    }
}
