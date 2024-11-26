package lotto

const val LOTTO_PRICE = 1000

class LottoCost(
    val value: Int,
    val manualLottoAmount: Int,
) {
    val autoLottoAmount: Int = value / LOTTO_PRICE - manualLottoAmount

    init {
        require(this.value >= 0) { "구입 금액은 유효한 양수로 입력해야합니다." }
        require(this.autoLottoAmount >= 0) { "구입 가능한 로또 갯수를 초과했습니다." }
    }
}
