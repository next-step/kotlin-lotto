package lotto.domain

import lotto.dto.PurchasedLotteryPapers

class LotteryPapers {
    private val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()

    fun generateRandomLottoNumber() {
        val generatedLotteryPaper = (LotteryPaper.MINIMUM_NUMBER..LotteryPaper.MAXIMUM_NUMBER)
            .shuffled()
            .take(LotteryPaper.NUMBER_OF_LOTTO_DRAWS)
        lotteryPaperList.add(LotteryPaper(generatedLotteryPaper))
    }

    fun getLottoResponse(): PurchasedLotteryPapers {
        val toList = lotteryPaperList.map { it.lottoNumber }.toList()
        return PurchasedLotteryPapers(toList)
    }
}
