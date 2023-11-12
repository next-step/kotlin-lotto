package lotto.domain

@JvmInline
value class LottoCount(
    val value: Int,
) {

    init {
        require(value >= LOTTO_MIN_COUNT) {
            "로또 개수는 ${LOTTO_MIN_COUNT}개 이상이어야 합니다."
        }
    }

    fun multiply(other: Int): Int =
        value * other

    fun plus(other: LottoCount): LottoCount =
        LottoCount(value + other.value)

    companion object {
        private const val LOTTO_MIN_COUNT = 0
    }
}
