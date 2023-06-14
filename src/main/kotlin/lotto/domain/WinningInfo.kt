package lotto.domain

class WinningInfo(private val values: Set<LottoNumber>, private val bonusNumber: LottoNumber) :
    Set<LottoNumber> by values {
    init {
        require(values.size == WINNING_NUMBERS_VALID_LENGTH) {
            "Require number size: ${Lotto.VALID_LENGTH}, Input: $values"
        }
    }

    fun matches(lotto: Lotto): Rank = values.count { it in lotto }
        .let { Rank.valueOf(matchCount = it, isBonus = bonusNumber in lotto) }

    companion object {
        const val WINNING_NUMBERS_VALID_LENGTH = 6
        const val DELIMITER = ","

        fun of(winningNumbersSource: List<String>, bonusNumberSource: Int): WinningInfo {
            val winningNumbers = winningNumbersSource.map(String::trim)
                .mapNotNull(String::toIntOrNull)
                .map(LottoNumber::valueOf)
                .toSet()

            val bonusNumber = LottoNumber.valueOf(bonusNumberSource)

            require(bonusNumber !in winningNumbers) {
                """The bonus number overlaps with the winning number. 
                    |Input WinningNumbers: $winningNumbers , 
                    |Input: bonusNumber: $bonusNumber""".trimMargin()
            }

            return WinningInfo(values = winningNumbers, bonusNumber = bonusNumber)
        }
    }
}
