package lotto.domain

class Lotto {

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

    fun generateLotto() {

    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000
    }
}
