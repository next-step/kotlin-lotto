package lotto.domain

data class ManualLottoCount(val manualLottoCount: Int, private val lottoCount: Int) {
    init {
        require(manualLottoCount >= 0) { "수동으로 구매할 로또의 갯수는 0 이상이어야 합니다." }
        require(lottoCount >= manualLottoCount) { "수동으로 구매할 로또 수는 구매 금액을 초과할 수 없다." }
    }
}
