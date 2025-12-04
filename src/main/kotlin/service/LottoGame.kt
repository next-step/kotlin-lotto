package service

import domain.Lotto
import domain.LottoNumber
import domain.LottoShuffler
import domain.LottoTicket
import domain.LottoWinningType
import domain.ProfitCalculator
import domain.WinningResult

class LottoGame(private val profitCalculator: ProfitCalculator = ProfitCalculator()) {
    fun generateLottoTicket(
        purchaseLottoCount: Int,
        manualLottos: List<Lotto>,
    ): LottoTicket {
        val automaticLottos = List(purchaseLottoCount - manualLottos.size) { LottoShuffler.generateAutomaticLotto() }
        return LottoTicket(manualLottos + automaticLottos)
    }

    fun getWinningResult(
        lottoTicket: LottoTicket,
        winningNumbers: List<LottoNumber>,
        bonusBall: LottoNumber,
        purchaseLottoAmount: Int,
    ): WinningResult {
        require(!winningNumbers.contains(bonusBall)) { "보너스 볼은 당첨 번호에 포함되면 안됩니다." }

        val result =
            lottoTicket.lottoTicket
                .groupingBy { getLottoWinningType(winningNumbers, it.lotto) }
                .eachCount()
                .withDefault { 0 }
        val profit = profitCalculator.calculateProfit(result, purchaseLottoAmount)

        return WinningResult(result, profit)
    }

    private fun getLottoWinningType(
        winningNumbers: List<LottoNumber>,
        lotto: Set<LottoNumber>,
    ): LottoWinningType {
        val matchingCount = winningNumbers.intersect(lotto).count()
        return LottoWinningType.fromMatchCount(matchingCount)
    }
}
