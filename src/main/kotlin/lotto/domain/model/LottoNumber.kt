package lotto.domain.model

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    init {
        require(value in LOTTO_NUMBER_RANGE) {
            "$MESSAGE_INVALID_NUMBER$value"
        }
    }

    companion object {
        private const val MESSAGE_INVALID_NUMBER = "로또 번호는 1에서 45까지의 숫자 중 하나로 이루어져야 합니다.\n현재 입력된 번호 : "

        private const val START_LOTTO_NUMBER = 1
        private const val END_LOTTO_NUMBER = 45

        val LOTTO_NUMBER_RANGE: IntRange = (START_LOTTO_NUMBER..END_LOTTO_NUMBER)
        private val LOTTO_NUMBERS: Map<Int, LottoNumber> = LOTTO_NUMBER_RANGE.associateWith(::LottoNumber)

        operator fun get(value: Int): LottoNumber {
            return requireNotNull(LOTTO_NUMBERS[value]) {
                "$MESSAGE_INVALID_NUMBER$value"
            }
        }
    }
}
