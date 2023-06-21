package lotto.domain

import lotto.dto.LottoResponse

class LotteryPapers {
    private val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()

    fun generateRandomLottoNumber() {
        val generatedLotteryPaper = (LotteryPaper.MINIMUM_NUMBER..LotteryPaper.MAXIMUM_NUMBER)
            .shuffled()
            .take(LotteryPaper.NUMBER_OF_LOTTO_DRAWS)
        lotteryPaperList.add(LotteryPaper(generatedLotteryPaper))
    }

    fun getLottoResponse(): LottoResponse {
        val toList = lotteryPaperList.map { it.lottoNumber }.toList()
        return LottoResponse(toList)
    }
}
