package lotto.domain

@JvmInline
value class LottoNumber private constructor(val value: Int) {

    companion object {
        const val LOTTO_NUMBER_START = 1
        const val LOTTO_NUMBER_END = 45

        fun valueOf(value: Int): LottoNumber {
            require(value in LOTTO_NUMBER_START..LOTTO_NUMBER_END) {
                "로또 숫자의 범위는 1~45 입니다."
            }
            return LottoNumber(value)
        }

        fun valueOf(value: String): LottoNumber {
            require(value.toIntOrNull() != null) {
                "숫자 이외의 값일 수 없습니다."
            }
            require(value.toInt() >= 0) {
                "숫자는 음수일 수 없습니다."
            }
            return valueOf(value.toInt())
        }
    }
}
