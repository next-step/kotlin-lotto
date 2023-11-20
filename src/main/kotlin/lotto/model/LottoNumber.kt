package lotto.model

class LottoNumber private constructor(val number: Int) {
    companion object {
        val LOTTO_NUMBER_RANGE = (1..45).toList()

        fun from(number: Int): LottoNumber {
            return LottoNumber(validateLottoNumberRange(number))
        }

        private fun validateLottoNumberRange(number: Int): Int {
            require(LOTTO_NUMBER_RANGE.contains(number)) {
                "로또 번호는 1 이상 45 이하의 자연수입니다."
            }

            return number
        }
    }
}
