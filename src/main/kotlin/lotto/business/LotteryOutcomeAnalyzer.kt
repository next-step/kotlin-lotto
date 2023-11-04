package lotto.business

class LotteryOutcomeAnalyzer {
    fun analyze(lottoWinningNumbers: LottoWinningNumbers, lottoTicket: LottoTicket): LotteryPrize {
        val matchCount = lottoTicket.matchCount(lottoWinningNumbers.lottoNumbers)
        return LotteryPrize.getPrize(matchCount)
    }
}
