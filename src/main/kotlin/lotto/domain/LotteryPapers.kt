package lotto.domain

import lotto.dto.PurchasedLotteryPapers

class LotteryPapers(private val lottoNumberGenerationStrategy: LottoNumberGenerationStrategy) {
    private val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()
    private val lotteryPaperValidator = LotteryPaperValidator()

    fun generateRandomLottoNumber() {
        val generatedLottoNumber = lottoNumberGenerationStrategy.generateLottoNumber()
        val generatedLotteryPaper = LotteryPaper(generatedLottoNumber)
        validateDuplicateLotteryPapers(lotteryPaperList, generatedLotteryPaper)
        lotteryPaperList.add(generatedLotteryPaper)
    }

    private fun validateDuplicateLotteryPapers(
        lotteryPaperList: List<LotteryPaper>,
        generatedLotteryPaper: LotteryPaper
    ) {
        lotteryPaperValidator.validateDuplicateLotteryPaper(lotteryPaperList)
        lotteryPaperValidator.validateIsAlreadyExistLotteryPaper(lotteryPaperList, generatedLotteryPaper)
    }

    fun getPurchasedLotteryPapers(): PurchasedLotteryPapers {
        val toList = lotteryPaperList.map { it }.toList()
        return PurchasedLotteryPapers(toList)
    }
}
