package lotto

val LOTTO_NUMBER_RANGE: IntRange = 1..45

@JvmInline
value class LottoNumber(
    val number: Int
) {
    init {
        require(LOTTO_NUMBER_RANGE.contains(number)) {
            "${LOTTO_NUMBER_RANGE.first}~${LOTTO_NUMBER_RANGE.last} 범위 숫자여야 합니다."
        }
    }

    override fun toString(): String {
        return "$number"
    }
}
