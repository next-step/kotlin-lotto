package lotto.domain

data class LottoNumber(private val number: Int) {

    fun toInt() = number

    companion object {
        private const val NUMBER_START = 1
        private const val NUMBER_END = 45
        val NUMBER_RANGE = NUMBER_START..NUMBER_END
        private val NUMBERS: Map<Int, LottoNumber> = (NUMBER_RANGE).associateWith { LottoNumber(it) }

        fun from(value: Int): LottoNumber {
            return NUMBERS[value] ?: throw IllegalArgumentException("범위에 벗어난 숫자입니다.")
        }

        fun ofBonusNumber(value: Int, winningNumber: LottoNumbers): LottoNumber {
            val bonusNumber = NUMBERS[value] ?: throw IllegalArgumentException("범위에 벗어난 숫자입니다.")
            require(winningNumber.checkOverlapToBonusNumber(bonusNumber)) { "당첨 번호와 겹치는 숫자가 있습니다." }
            return bonusNumber
        }
    }
}
