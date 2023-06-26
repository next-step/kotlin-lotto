package lotto.domain

class Lotto {

    var lotteryPapers: LotteryPapers = LotteryPapers(RandomLottoNumberGenerationStrategy())
        private set

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
        repeat(numOfLottoPurchases) { lotteryPapers.generateRandomLottoNumber() }
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000
    }
}
