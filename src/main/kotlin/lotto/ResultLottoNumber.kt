package lotto

import lotto.enums.LottoReturn

class ResultLottoNumber private constructor(
    val defaultLottoNumber: DefaultLottoNumber,
    val bonusNumber: Int,
) {
    init {
        val numbers = defaultLottoNumber.numbers + bonusNumber
        require(numbers.all { it in LOTTO_NUMBER_RANGE }) { "범위를 벗어난 숫자가 있습니다." }
        require(numbers.distinct().size == TOTAL_LOTTO_NUMBER_COUNT) { "중복된 숫자가 있습니다." }
    }

    fun decideReturn(defaultNumber: DefaultLottoNumber): LottoReturn {
        return LottoReturn.from(
            matchCount = this.defaultLottoNumber.countMatch(defaultNumber),
            bonusMatch = defaultNumber.numbers.contains(this.bonusNumber),
        )
    }

    companion object {
        const val TOTAL_LOTTO_NUMBER_COUNT = 7
        val LOTTO_NUMBER_RANGE = 1..45

        fun from(defaultNumbers: List<Int>, bonusNumber: Int): ResultLottoNumber {
            return ResultLottoNumber(
                defaultLottoNumber = DefaultLottoNumber.from(defaultNumbers),
                bonusNumber = bonusNumber,
            )
        }
    }
}
