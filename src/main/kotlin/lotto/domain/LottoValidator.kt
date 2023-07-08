package lotto.domain

class LottoValidator {

    fun validateInputMoneyCanBuyLottoTicket(money: Int) {
        require(money >= LottoMachine.LOTTO_TICKET_PRICE) { "구입 금액은 로또 1개의 금액보다 커야합니다." }
    }

    fun validateLottoTicket(numberOfLottoTicket: Int, manualBuyLotteryPaper: List<LotteryPaper>) {
        require(numberOfLottoTicket >= manualBuyLotteryPaper.size) { "수동 구매 수량은 전체 구매 수량보다 크면 안됩니다." }
    }
}
