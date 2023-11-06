package lotto.model

data class LottoNumber(
    val value: Int,
) {
    init {
        require(value in LOWER_LIMIT_VALUE..UPPER_LIMIT_VALUE) { "입력한 [$value] 는 허용 범위 $LOWER_LIMIT_VALUE 부터 $UPPER_LIMIT_VALUE 사이의 숫자가 아닙니다" }
    }

    companion object {
        private const val UPPER_LIMIT_VALUE: Int = 46
        private const val LOWER_LIMIT_VALUE: Int = 1
        private val LOTTO_NUMBERS: LinkedHashSet<LottoNumber> = LinkedHashSet((1..46).map { LottoNumber(it) })

        fun any6Numbers(): LinkedHashSet<LottoNumber> {
            return LinkedHashSet(
                LOTTO_NUMBERS.shuffled()
                    .subList(0, 6)
            )
        }
    }
}
