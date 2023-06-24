package lotto.domain

class LottoValidator {

    fun validateInputMoneyCanBuyLottoTicket(money: Int) {
        require(money >= 1000)
    }

    fun validateNumOfLottoPurchases(numOfLottoPurchases: Int) {
        require(numOfLottoPurchases > 0)
    }
}