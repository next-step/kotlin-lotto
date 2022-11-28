package nextstep.mission.lotto

import nextstep.mission.lotto.vo.LottoNumbers
import nextstep.mission.lotto.vo.WinningPrize
import nextstep.mission.lotto.vo.WinningResult

class Lotto(val lottoNumbers: List<LottoNumbers>) {

    fun matchWinningNumbers(winningNumbers: LottoNumbers): WinningResult {
        tailrec fun match(
            winningNumbers: LottoNumbers,
            lottoNumbers: MutableList<LottoNumbers> = this.lottoNumbers.toMutableList(),
            result: MutableMap<WinningPrize, Int> = WinningPrize.values().associateWith { 0 }.toMutableMap()
        ): WinningResult = when {
            lottoNumbers.isEmpty() -> WinningResult(result.toMap())
            else -> {
                val matchedCount: Int = lottoNumbers.removeFirst().match(winningNumbers)
                WinningPrize.find(matchedCount)?.also { result[it] = result[it]!! + 1 }
                match(winningNumbers, lottoNumbers, result)
            }
        }
        return match(winningNumbers = winningNumbers)
    }
}
