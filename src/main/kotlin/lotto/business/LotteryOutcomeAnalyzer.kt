package lotto.business

class LotteryOutcomeAnalyzer {
    fun analyze(lottoWinningNumbers: LottoWinningNumbers, lottoTicket: LottoTicket): LotteryPrize {
        val matchCount = lottoWinningNumbers.matchCount(lottoTicket)
        return LotteryPrize.getPrize(matchCount)
    }
}
