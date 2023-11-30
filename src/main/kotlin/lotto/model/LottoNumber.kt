package lotto.model

@JvmInline
value class LottoNumber(
    val value: Int,
) {
    init {
        requireValueInRange(value)
    }

    private fun requireValueInRange(value: Int) {
        require(value in LOWER_LIMIT_VALUE..UPPER_LIMIT_VALUE) { "입력한 [$value] 는 허용 범위 $LOWER_LIMIT_VALUE 부터 $UPPER_LIMIT_VALUE 사이의 숫자가 아닙니다" }
    }

    companion object {
        const val UPPER_LIMIT_VALUE: Int = 46
        const val LOWER_LIMIT_VALUE: Int = 1
    }
}
