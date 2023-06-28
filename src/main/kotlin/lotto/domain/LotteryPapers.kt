package lotto.domain

import lotto.dto.PurchasedLotteryPapers

class LotteryPapers(private val lottoNumberGenerationStrategy: LottoNumberGenerationStrategy) {
    private val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()
    private val lotteryPaperValidator = LotteryPaperValidator()

    fun generateRandomLottoNumber() {
        var generatedLottoNumber: List<Int>
        var generatedLotteryPaper: LotteryPaper

        do {
            generatedLottoNumber = lottoNumberGenerationStrategy.generateLottoNumber()
            generatedLotteryPaper = LotteryPaper(generatedLottoNumber)
        } while (lotteryPaperValidator.isAlreadyExistLotteryPaper(lotteryPaperList, generatedLotteryPaper))

        lotteryPaperList.add(generatedLotteryPaper)
    }

    fun getPurchasedLotteryPapers(): PurchasedLotteryPapers {
        val toList = lotteryPaperList.map { it }.toList()
        return PurchasedLotteryPapers(toList)
    }
}
