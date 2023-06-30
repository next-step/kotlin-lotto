package lotto

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    init {
        require(value in LOTTO_NUMBER_RANGE) { "범위를 벗어난 숫자가 있습니다." }
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45

        fun build(number: Int): LottoNumber {
            return LottoNumber(number)
        }
    }
}