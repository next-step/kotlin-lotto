package lotto.ticket

data class LottoNumber(private val number: Int) {

    companion object {
        private const val LOTTO_NUMBER_UNDER_BOUND = 1
        private const val LOTTO_NUMBER_UPPER_BOUND = 45

        fun ofNumber(number: Int): LottoNumber {
            require(enableLottoNumber(number)) { "로또 번호는 1 ~ 45 사이의 값이어야 합니다. - $number" }
            return LottoNumber(number)
        }

        private fun enableLottoNumber(number: Int) =
            number < LOTTO_NUMBER_UNDER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND
    }
}