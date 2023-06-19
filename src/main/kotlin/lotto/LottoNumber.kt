package lotto

import lotto.enums.LottoReturn

class LottoNumber private constructor(
    val defaultNumbers: DefaultNumbers,
    val bonusNumber: Int,
) {
    init {
        val numbers = defaultNumbers.numbers + bonusNumber
        require(numbers.all { it in LOTTO_NUMBER_RANGE }) { "범위를 벗어난 숫자가 있습니다." }
        require(numbers.distinct().size == TOTAL_LOTTO_NUMBER_COUNT) { "중복된 숫자가 있습니다." }
    }

    fun decideReturn(other: LottoNumber): LottoReturn {
        return LottoReturn.from(
            matchCount = this.defaultNumbers.countMatch(other.defaultNumbers),
            bonusMatch = this.bonusNumber == other.bonusNumber,
        )
    }

    companion object {
        const val TOTAL_LOTTO_NUMBER_COUNT = 7
        val LOTTO_NUMBER_RANGE = 1..45

        fun from(defaultNumbers: List<Int>, bonusNumber: Int): LottoNumber {
            return LottoNumber(
                defaultNumbers = DefaultNumbers.from(defaultNumbers),
                bonusNumber = bonusNumber,
            )
        }
    }
}
