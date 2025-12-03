package domain.winning

import domain.lotto.Lotto
import domain.lotto.LottoNumber

data class WinningLotto(
    private val winningLotto: Lotto,
    private val bonusNumber: LottoNumber,
) {
    fun determineWinningType(lotto: Lotto): LottoWinningType {
        val matchingCount = lotto.numbers.intersect(winningLotto.numbers).count()
        val bonusNumberMatched = bonusNumber in lotto.numbers
        return LottoWinningType.of(matchingCount, bonusNumberMatched)
    }
}
