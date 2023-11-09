package lotto.component

import lotto.model.*

class Lotto(
    private val lottoNumbersGenerator: LottoNumbersGenerator
) {

    fun draw(lottoInput: LottoInput, winningNumbers: WinningNumbers): LottoResult {
        val lottoTicketCount = lottoInput.lottoTicketCount
        val lottoTickets = lottoNumbersGenerator.generate(lottoTicketCount)

        val lottoPrizes = getLottoPrizes(lottoTickets, winningNumbers)

        return LottoResult(lottoPrizes)
    }

    private fun getLottoPrizes(lottoTickets: List<LottoTicket>, winningNumbers: WinningNumbers): List<LottoPrize> {
        return lottoTickets
            .map { winningNumbers.match(it.lottoNumbers) }
            .map { LottoPrize.create(it) }
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
