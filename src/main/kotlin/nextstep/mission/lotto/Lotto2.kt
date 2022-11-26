package nextstep.mission.lotto

import nextstep.mission.lotto.vo.LottoNumbers
import nextstep.mission.lotto.vo.WinningResult2

class Lotto2(val lottoNumbers: List<LottoNumbers>) {

    fun matchWinningNumbers(winningNumbers: LottoNumbers): WinningResult2 {
        tailrec fun match(
            winningNumbers: LottoNumbers,
            lottoNumbers: MutableList<LottoNumbers> = this.lottoNumbers.toMutableList(),
            result: MutableMap<WinningPrize, Int> = WinningPrize.values().associateWith { 0 }.toMutableMap()
        ): WinningResult2 = when {
            lottoNumbers.isEmpty() -> WinningResult2(result.toMap())
            else -> {
                val matchedCount: Int = lottoNumbers.removeFirst().match(winningNumbers)
                WinningPrize.find(matchedCount)?.also { result[it] = result[it]!! + 1 }
                match(winningNumbers, lottoNumbers, result)
            }
        }
        return match(winningNumbers = winningNumbers)
    }
}
