package lotto.entity

import lotto.domain.LottoMatchResult
import lotto.domain.LottoNumber
import lotto.domain.WinningLottoNumber

class Lotto(val manualLotto: MutableList<LottoNumber>, val autoLotto: MutableList<LottoNumber>) {

    fun compareAllWithWinningNumbers(winningLottoNumber: WinningLottoNumber): List<LottoMatchResult> {
        return (manualLotto + autoLotto).map { lottoNumber ->
            lottoNumber.compareWithWinningNumbers(winningLottoNumber)
        }
    }
}
