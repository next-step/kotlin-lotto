package lotto.domain

import lotto.dto.LottoOrder
import lotto.dto.LotteryPapers

class LottoMachine(private val lotteryPaperFactory: LotteryPaperFactory) {
    private val lottoValidator = LottoValidator()

    fun buyLottoTicket(lottoOrder: LottoOrder): LotteryPapers {
        val (purchasingAmount, manualBuyLotteryPaper) = lottoOrder

        lottoValidator.validateInputMoneyCanBuyLottoTicket(purchasingAmount)
        val numberOfLottoTicket = calculateNumberOfLottoTicket(purchasingAmount)

        lottoValidator.validateLottoTicket(numberOfLottoTicket, manualBuyLotteryPaper)
        val generatedLottoNumbers = generateLottoNumbers(numberOfLottoTicket, manualBuyLotteryPaper)

        return LotteryPapers(generatedLottoNumbers)
    }

    private fun calculateNumberOfLottoTicket(money: Int): Int {
        return money / LOTTO_TICKET_PRICE
    }

    private fun generateLottoNumbers(
        numOfLottoPurchases: Int,
        manualBuyLotteryPaper: List<LotteryPaper>
    ): List<LotteryPaper> {
        val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()
        lotteryPaperList.addAll(manualBuyLotteryPaper)
        repeat(numOfLottoPurchases - manualBuyLotteryPaper.size) {
            val generatedLottoNumber = lotteryPaperFactory.generateLotteryPaper(lotteryPaperList.toList())
            lotteryPaperList.add(generatedLottoNumber)
        }
        return lotteryPaperList.toList()
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000
    }
}
