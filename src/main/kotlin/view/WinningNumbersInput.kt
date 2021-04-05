package view

import domain.lotto.LottoNumber
import domain.winning.WinningNumbers

data class WinningNumbersInput(val numbers: ParsedManualNumbers, val bonus: Int) {
    fun toWinningNumbers(): WinningNumbers {
        return WinningNumbers(
            numbers = numbers.toLottoNumbers(),
            bonus = LottoNumber.parse(bonus)
        )
    }
}
