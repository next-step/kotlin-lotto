package lotto.domain

import lotto.dto.PurchasedLotteryPapers

class LotteryPapers(private val lottoNumberGenerationStrategy: LottoNumberGenerationStrategy) {
    private val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()

    fun generateRandomLottoNumber() {
        val generatedLottoNumber = lottoNumberGenerationStrategy.generateLottoNumber()
        validateDuplicateLotteryPaper(lotteryPaperList)
        lotteryPaperList.add(LotteryPaper(generatedLottoNumber))
    }

    fun getPurchasedLotteryPapers(): PurchasedLotteryPapers {
        val toList = lotteryPaperList.map { it }.toList()
        return PurchasedLotteryPapers(toList)
    }

    companion object {
        fun validateDuplicateLotteryPaper(lotteryPaperList: List<LotteryPaper>) {
            require(lotteryPaperList.toSet().size == lotteryPaperList.size) {
                "중복된 로또 용지가 존재합니다. 입력값을 다시 확인하세요."
            }
        }
    }
}
