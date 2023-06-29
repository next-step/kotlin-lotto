package lotto.domain

import lotto.dto.PurchasedLotteryPapers

class LottoShop {

    private val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()
    private val lotteryPaperFactory: LotteryPaperFactory = LotteryPaperFactory(RandomLottoNumberGenerationStrategy())
    private val lottoValidator = LottoValidator()

    fun buyLottoTicket(money: Int): Int {
        lottoValidator.validateInputMoneyCanBuyLottoTicket(money)
        return calculateNumberOfLottoTicket(money)
    }

    private fun calculateNumberOfLottoTicket(money: Int): Int {
        return money / LOTTO_TICKET_PRICE
    }

    fun generateLottoNumbers(numOfLottoPurchases: Int) {
        lottoValidator.validateNumOfLottoPurchases(numOfLottoPurchases)
        repeat(numOfLottoPurchases) {
            val generatedLottoNumber = lotteryPaperFactory.generateLottoNumber(lotteryPaperList.toList())
            lotteryPaperList.add(generatedLottoNumber)
        }
    }

    fun getPurchasedLotteryPapers(): PurchasedLotteryPapers {
        val toList = lotteryPaperList.map { it }.toList()
        return PurchasedLotteryPapers(toList)
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000
    }
}
