package nextstep.mission.lotto

import nextstep.mission.lotto.vo.LottoNumber
import nextstep.mission.lotto.vo.LottoNumbers
import nextstep.mission.lotto.vo.WinningPrize
import nextstep.mission.lotto.vo.WinningResult

@JvmInline
value class Lotto(val lottoNumbers: List<LottoNumbers>) {

    fun matchWinningNumbers(winningNumbers: LottoNumbers, bonusNumber: LottoNumber): WinningResult {
        tailrec fun match(
            winningNumbers: LottoNumbers,
            bonusNumber: LottoNumber,
            lottoNumbers: MutableList<LottoNumbers> = this.lottoNumbers.toMutableList(),
            result: MutableMap<WinningPrize, Int> = WinningPrize.values().associateWith { 0 }.toMutableMap()
        ): WinningResult = when {
            lottoNumbers.isEmpty() -> WinningResult(result.toMap())
            else -> {
                val currentLottoNumbers: LottoNumbers = lottoNumbers.removeFirst()
                WinningPrize.find(
                    currentLottoNumbers.match(winningNumbers),
                    bonusNumber in currentLottoNumbers
                )?.also { result[it] = result[it]!! + 1 }
                match(winningNumbers, bonusNumber, lottoNumbers, result)
            }
        }
        return match(winningNumbers = winningNumbers, bonusNumber = bonusNumber)
    }

    operator fun plus(other: Lotto): Lotto = Lotto(this.lottoNumbers + other.lottoNumbers)
}
