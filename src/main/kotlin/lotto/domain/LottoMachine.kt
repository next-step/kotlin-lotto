package lotto.domain

import lotto.dto.PurchasedLotteryPapers

class LottoMachine {

    private val lotteryPaperList: MutableList<LotteryPaper> = mutableListOf()
    private val lotteryPaperFactory: LotteryPaperFactory = LotteryPaperFactory(RandomLottoNumberGenerationStrategy())
    private val lottoValidator = LottoValidator()

    fun buyLottoTicket(money: Int): Int {
        lottoValidator.validateInputMoneyCanBuyLottoTicket(money)
        val numberOfLottoTicket = calculateNumberOfLottoTicket(money)
        generateLottoNumbers(numberOfLottoTicket)
        return numberOfLottoTicket
    }

    private fun calculateNumberOfLottoTicket(money: Int): Int {
        return money / LOTTO_TICKET_PRICE
    }

    private fun generateLottoNumbers(numOfLottoPurchases: Int) {
        repeat(numOfLottoPurchases) {
            val generatedLottoNumber = lotteryPaperFactory.generateLotteryPaper(lotteryPaperList.toList())
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
