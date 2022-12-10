package step2.lotto.domain

class LottoNumber private constructor(value: Int) {
    companion object {
        private const val START_RANGE = 1
        private const val END_RANGE = 45
        private const val OUT_OF_LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 범위에 해당하는 숫자가 아닙니다. [%d], [$START_RANGE ~ $END_RANGE] 범위에 숫자만 입력하세요."
        private val LOTTO_NUMBER_RANGE: IntRange = START_RANGE..END_RANGE
        private val lottoNumbers: Map<Int, LottoNumber> = init()

        private fun init(): Map<Int, LottoNumber> = mutableMapOf<Int, LottoNumber>().apply {
            repeat(END_RANGE) {
                this[it + 1] = LottoNumber(it + 1)
            }
        }

        fun of(randomNumber: Int): LottoNumber {
            validateRandomNumber(randomNumber)
            return lottoNumbers.getValue(randomNumber)
        }

        private fun validateRandomNumber(inputNumber: Int): Unit = require(isRangeToLottoNumber(inputNumber)) { OUT_OF_LOTTO_NUMBER_RANGE_ERROR_MESSAGE.format(inputNumber) }

        private fun isRangeToLottoNumber(inputNumber: Int): Boolean = inputNumber in (LOTTO_NUMBER_RANGE)
    }
}
