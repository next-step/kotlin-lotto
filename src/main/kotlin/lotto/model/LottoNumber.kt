package lotto.model

class LottoNumber private constructor(
    val number: Int
) {

    init {
        validateMinLottoNumber(number)
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        private val LOTTO_NUMBERS = List(MAX_LOTTO_NUMBER) {
            LottoNumber(it + MIN_LOTTO_NUMBER)
        }

        fun from(number: Int): LottoNumber {
            validateMinLottoNumber(number)

            return LOTTO_NUMBERS[number - 1]
        }

        private fun validateMinLottoNumber(number: Int) {
            require(number >= MIN_LOTTO_NUMBER) { "로또 숫자는 최소 $MIN_LOTTO_NUMBER 이상이어야 합니다. (number: $number)" }
        }
    }
}
