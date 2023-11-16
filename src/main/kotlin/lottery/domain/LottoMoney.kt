package lottery.domain

import lottery.domain.LottoGame.Companion.LOTTERY_PRICE

data class LottoMoney(
    val money: Int,
    val manualLottoCount: Int,
    val autoLottoCount: Int,
) {
    init {
        require(money >= manualLottoCount.times(LOTTERY_PRICE)) { INVALID_MANUAL_LOTTO_COUNT_EXCEPTION }
    }

    constructor(money: Int, manualLottoCount: Int) : this(
        money,
        manualLottoCount,
        autoLottoCount = money.div(LOTTERY_PRICE).minus(manualLottoCount)
    )

    companion object {
        private const val INVALID_MANUAL_LOTTO_COUNT_EXCEPTION = "구매 가능한 로또 갯수를 초과했습니다"
    }
}
