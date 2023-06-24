package step2Lotto.domain

import step2Lotto.domain.dto.StatisticsRequest

class LottoService(
    private val lottoGenerator: LottoGenerator
) {
    fun getLottoTicketQuantity(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    fun purchaseLottoTickets(lottoTicketQuantity: Int): List<Lotto> {
        return List(lottoTicketQuantity) { lottoGenerator.execute() }
    }

    fun getStatistics(req: StatisticsRequest): List<LottoRank> {
        return req.lottoTickets.map { getLottoRank(it, req.winningNumber) }
    }

    private fun getLottoRank(lotto: Lotto, winningNumber: Lotto): LottoRank {
        return when (lotto.numbers.intersect(winningNumber.numbers.toSet()).size) {
            3 -> LottoRank.FIFTH
            4 -> LottoRank.FOURTH
            5 -> LottoRank.THIRD
            6 -> LottoRank.FIRST
            else -> LottoRank.LOSE
        }
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
