package lotto.domain

class Lotto {

    var lottoNumbers: LottoNumbers = LottoNumbers()
        private set

    fun buyLottoTicket(money: Int): Int {
        validateInputMoneyCanBuyLottoTicket(money)
        return calculateNumberOfLottoTicket(money)
    }

    private fun validateInputMoneyCanBuyLottoTicket(money: Int) {
        require(money >= 1000)
    }

    private fun calculateNumberOfLottoTicket(money: Int): Int {
        return money / LOTTO_TICKET_PRICE
    }

    fun generateLottoNumbers(numOfLottoPurchases: Int) {
        validateNumOfLottoPurchases(numOfLottoPurchases)
        for (i in 0 until numOfLottoPurchases) {
            lottoNumbers.generateRandomLottoNumber()
        }
    }

    private fun validateNumOfLottoPurchases(numOfLottoPurchases: Int) {
        require(numOfLottoPurchases > 0)
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000
    }
}
