package lotto.domain

data class ManualLottoCount(val manualLottoCount: Int, private val lottoCount: Int) {
    init {
        require(lottoCount >= manualLottoCount) { "수동으로 구매할 로또 수는 구매 금액을 초과할 수 없다." }
    }
}
