package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {
    operator fun compareTo(value: Int): Int {
        return this.value.compareTo(value)
    }

    init {
        require(value in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) { WRONG_LOTTO_NUMBER_MESSAGE }
    }

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
        private const val WRONG_LOTTO_NUMBER_MESSAGE = "잘못된 로또 번호 입니다.($MINIMUM_LOTTO_NUMBER~$MAXIMUM_LOTTO_NUMBER 입력})"

        fun from(input: String): LottoNumber {
            val value = input.toIntOrNull()
            require( value != null) { WRONG_LOTTO_NUMBER_MESSAGE }
            return LottoNumber(value)
        }
    }
}
