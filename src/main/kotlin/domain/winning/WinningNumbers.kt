package domain.winning

import domain.lotto.Lotto
import domain.lotto.LottoNumber
import domain.lotto.LottoNumbers

class WinningNumbers(val numbers: LottoNumbers, val bonus: LottoNumber) {
    init {
        require(numbers.toList().none { it == bonus })
    }

    fun determineWinning(lotto: Lotto): WinningCategory? {
        return WinningCategory.matchNumberOf(lotto.countMatchedBy(numbers), bonus in lotto.numbers)
    }
}
