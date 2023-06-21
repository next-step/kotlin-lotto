package lotto.domain

class LotteryPaper(val lottoNumber: List<Int>) {
    companion object {
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        const val NUMBER_OF_LOTTO_DRAWS = 6
        private val LOTTO_NUMBER_BOUNDS = MINIMUM_NUMBER..MAXIMUM_NUMBER

        fun validateLottoNumber(lottoNumber: List<Int>) {
            validateInLottoNumberBounds(lottoNumber)
            validateNonDupulicatedLottoNumber(lottoNumber)
        }

        private fun validateInLottoNumberBounds(lottoNumber: List<Int>) {
            lottoNumber.forEach {
                require(it in LOTTO_NUMBER_BOUNDS) { "로또 범위의 숫자만 가능합니다. 입력값을 다시 확인하세요." }
            }
        }

        private fun validateNonDupulicatedLottoNumber(lottoNumber: List<Int>) {
            require(lottoNumber.toSet().size == lottoNumber.size) {
                "로또 숫자는 중복되면 안됩니다. 입력값을 다시 확인하세요."
            }
        }
    }
}
