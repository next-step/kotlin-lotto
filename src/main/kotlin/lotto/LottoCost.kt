package lotto

const val LOTTO_PRICE = 1000

@JvmInline
value class LottoCost(
    val value: Int,
) {
    init {
        require(this.value >= 0) { "구입 금액은 유효한 양수로 입력해야합니다." }
    }

    fun calculateBoughtLottoAmount(): Int {
        return value / LOTTO_PRICE
    }
}

@JvmInline
value class ManualLottoAmount(
    val value: Int,
)
