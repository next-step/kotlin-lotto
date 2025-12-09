package lotto.domain

class LottoShop private constructor() {
    companion object {
        const val LOTTO_UNIT_PRICE = 1000
        private const val ERROR_MESSAGE_INVALID_UNIT = "${LOTTO_UNIT_PRICE}원 단위로 입력해주세요"

        fun sellLotto(
            money: Money,
            manualLottoOrder: ManualLottoOrder,
        ): LottoTicket {
            require(money.price % LOTTO_UNIT_PRICE == 0) { ERROR_MESSAGE_INVALID_UNIT }
            val autoLottoCount = (money.price - manualLottoOrder.usedMoney.price) / LOTTO_UNIT_PRICE
            return LottoTicket(money, manualLottoOrder.lottos, List(autoLottoCount) { Lotto.createRandom() })
        }
    }
}
