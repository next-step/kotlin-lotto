package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoConstants.LOTTO_PRICE
import lotto.domain.LottoRandomGenerator
import lotto.domain.WinningResult

class LottoService {
    fun purchase(paidMoney: Int): List<Lotto> {
        val purchaseTime = paidMoney / LOTTO_PRICE
        require(paidMoney >= LOTTO_PRICE) { "로또 구입 금액은 1000원 이상이어야 합니다." }

        return (1..purchaseTime).map { LottoRandomGenerator.randomGenerate() }
    }

    fun calculateWinningResult(
        tickets: List<Lotto>,
        winningNumbers: Lotto,
    ): WinningResult {
        val winningStatistics =
            tickets.map { it.match(winningNumbers) }
                .groupBy { it }
                .mapValues { it.value.size }
                .filterKeys { it >= 3 }

        return WinningResult(winningStatistics)
    }
}
