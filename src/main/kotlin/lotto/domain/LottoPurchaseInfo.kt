package lotto.domain

class LottoPurchaseInfo(money: Int, val manualLottoCount: Int) {

    init {
        require(money >= LottoTickets.LOTTO_PRICE) {
            "로또 구매 금액은 1000원 이상이어야 합니다. 입력된 금액 = $money"
        }

        require(manualLottoCount >= 0) {
            "수동으로 구매할 로또 수는 0 이상이어야 합니다. 입력된 수 = $manualLottoCount"
        }

        require(money >= manualLottoCount * LottoTickets.LOTTO_PRICE) {
            "수동으로 구매할 로또 수는 구매 금액을 초과할 수 없습니다." +
                " 입력된 금액 = $money, 입력된 수 = $manualLottoCount"
        }
    }

    val autoLottoCount =
        (money - manualLottoCount * LottoTickets.LOTTO_PRICE) / LottoTickets.LOTTO_PRICE
}
