package lotto.domain

data class LottoNumber private constructor(
    val value: Int
) {
    companion object {
        private const val MINIMUM_VALUE = 1
        private const val MAXIMUM_VALUE = 45

        private val LOTTO_NUMBERS: Map<Int, LottoNumber> = (MINIMUM_VALUE..MAXIMUM_VALUE).associateWith(::LottoNumber)

        fun from(value: Int): LottoNumber {
            return requireNotNull(LOTTO_NUMBERS[value]) {
                "로또 숫자의 범위는 $MINIMUM_VALUE ~ $MAXIMUM_VALUE 입니다."
            }
        }

        fun toLottoNumberList(): List<LottoNumber> {
            return LOTTO_NUMBERS.values
                .toList()
        }
    }
}
