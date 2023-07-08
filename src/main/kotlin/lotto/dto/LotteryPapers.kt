package lotto.dto

import lotto.domain.LotteryPaper
import lotto.domain.LotteryPaperValidator

data class LotteryPapers(val lotteryPaperList: List<LotteryPaper>) {
    private val lotteryPaperValidator = LotteryPaperValidator()

    init {
        validateEachLottoPaper()
        validateLottoPaperList()
    }

    private fun validateEachLottoPaper() {
        lotteryPaperList.forEach {
            LotteryPaper.validateLottoNumber(it.getLottoNumbers())
        }
    }

    private fun validateLottoPaperList() {
        lotteryPaperValidator.validateDuplicateLotteryPaper(lotteryPaperList)
    }
}
