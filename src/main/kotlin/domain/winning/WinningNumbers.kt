package domain.winning

import domain.lotto.Lotto
import domain.lotto.LottoNumber
import domain.lotto.LottoNumbers

class WinningNumbers(val numbers: LottoNumbers, val bonus: LottoNumber) {
    init {
        require(numbers.toList().none { it == bonus })
    }

    fun determineWinning(lotto: Lotto): WinningCategory? {
        val category = WinningCategory.matchNumberOf(lotto.countMatchedBy(numbers))
            ?: return null

        if (category == WinningCategory.FIVE_CORRECT && bonus in lotto.numbers) {
            return WinningCategory.FIVE_WITH_BONUS_CORRECT
        }

        return category
    }
}
