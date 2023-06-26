package lotto.domain

import lotto.dto.PurchasedLotteryPapers

class LotteryPapers(private val lottoNumberGenerationStrategy: LottoNumberGenerationStrategy) {
    private val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()

    fun generateRandomLottoNumber() {
        val generateLottoNumber = lottoNumberGenerationStrategy.generateLottoNumber()
        lotteryPaperList.add(LotteryPaper(generateLottoNumber))
    }

    fun getPurchasedLotteryPapers(): PurchasedLotteryPapers {
        val toList = lotteryPaperList.map { it.lottoNumber }.toList()
        return PurchasedLotteryPapers(toList)
    }
}
