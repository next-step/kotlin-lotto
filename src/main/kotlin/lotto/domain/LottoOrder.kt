package lotto.domain

import kotlin.properties.Delegates

class LottoOrder(private val money: Int, val manualLottoCount: Int) {
    var autoLottoCount by Delegates.notNull<Int>()
        private set

    init {
        val lottoCount = money / Lotto.LOTTO_PRICE
        require(lottoCount >= manualLottoCount) { "수동으로 구매할 로또 수가 전체 로또 수보다 많습니다." }
        autoLottoCount = lottoCount - manualLottoCount
    }
}
