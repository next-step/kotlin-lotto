package lotto.domain

class LottoTestHelper {
    companion object {
        fun createPurchasedLotteryPapers(): List<LotteryPaper> {
            return listOf(
                createLotteryPaper(1, 2, 3, 4, 5, 6),
                createLotteryPaper(2, 3, 4, 5, 6, 7),
                createLotteryPaper(3, 4, 5, 6, 7, 8),
                createLotteryPaper(4, 5, 6, 7, 8, 9)
            )
        }

        fun createLotteryPaper(vararg numbers: Int): LotteryPaper {
            return LotteryPaper(numbers.map { LottoNumber(it) })
        }
    }
}
