package lotto.model

@JvmInline
value class LottoNumber(
    val number: Int
) {

    init {
        validateNumberRange(number)
    }

    override fun toString(): String {
        return "$number"
    }

    companion object {
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45

        val LOTTO_NUMBERS = List(MAX_LOTTO_NUMBER) {
            LottoNumber(it + MIN_LOTTO_NUMBER)
        }

        private fun validateNumberRange(number: Int) =
            require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
                "로또 숫자는 $MIN_LOTTO_NUMBER 이상 $MAX_LOTTO_NUMBER 이하이어야 합니다. (number: $number)"
            }
    }
}
