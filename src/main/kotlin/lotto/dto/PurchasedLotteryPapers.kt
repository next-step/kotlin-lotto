package lotto.dto

import lotto.domain.LotteryPaper
import lotto.domain.LotteryPapers

data class PurchasedLotteryPapers(val lotteryPaperList: List<LotteryPaper>) {

    init {
        validateEachLottoPaper()
        validateLottoPaperList()
    }

    private fun validateEachLottoPaper() {
        lotteryPaperList.forEach {
            LotteryPaper.validateLottoNumber(it.lottoNumber)
        }
    }

    private fun validateLottoPaperList() {
        LotteryPapers.isDuplicateLotteryPaper(lotteryPaperList)
    }
}
