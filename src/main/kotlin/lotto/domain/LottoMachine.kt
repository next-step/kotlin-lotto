package lotto.domain

import lotto.dto.PurchasedLotteryPapers

class LottoMachine(private val lotteryPaperFactory: LotteryPaperFactory) {
    private val lottoValidator = LottoValidator()

    fun buyLottoTicket(money: Int): PurchasedLotteryPapers {
        lottoValidator.validateInputMoneyCanBuyLottoTicket(money)
        val numberOfLottoTicket = calculateNumberOfLottoTicket(money)
        val generatedLottoNumbers = generateLottoNumbers(numberOfLottoTicket)
        return PurchasedLotteryPapers(generatedLottoNumbers)
    }

    private fun calculateNumberOfLottoTicket(money: Int): Int {
        return money / LOTTO_TICKET_PRICE
    }

    private fun generateLottoNumbers(numOfLottoPurchases: Int): List<LotteryPaper> {
        val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()
        repeat(numOfLottoPurchases) {
            val generatedLottoNumber = lotteryPaperFactory.generateLotteryPaper(lotteryPaperList.toList())
            lotteryPaperList.add(generatedLottoNumber)
        }
        return lotteryPaperList.toList()
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000
    }
}
