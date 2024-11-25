package lotto

const val LOTTO_PRICE = 1000

class LottoCost(
    value: String?,    
) {
    val value: Int
    
    init {
        requireNotNull(value) { "구입 금액은 필수입니다." }
        this.value = try {
            value.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("구입 금액은 숫자만 입력가능합니다.")
        }
        require(this.value >= 0) { "구입 금액은 유효한 양수로 입력해야합니다." }
    }

    fun calculateBoughtLottoAmount(): Int {
        return value / LOTTO_PRICE
    }
}
