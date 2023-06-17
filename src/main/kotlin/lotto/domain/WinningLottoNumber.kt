package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class WinningLottoNumber(
    private val winningNumbers: LottoNumbers,
    private val bonusLottoNumber: LottoNumber,
) {

    init {
        val duplicatedNumber = winningNumbers.contains(bonusLottoNumber)
        require(!duplicatedNumber) { "보너스 번호가 이미 당첨 번호에 있습니다." }
    }

    fun makeRankingCountMap(lotteryTickets: LotteryTickets): Map<LottoRanking, Int> =
        lotteryTickets.groupingBy { this.getRanking(it.lottoNumbers) }.eachCount()

    fun getRevenueRate(lotteryTickets: LotteryTickets): BigDecimal {
        val totalWinningAmount = lotteryTickets.sumOf { this.getRanking(it.lottoNumbers).winningAmount }
        val totalPurchaseAmount = BigDecimal(lotteryTickets.size * LottoStore.PURCHASE_AMOUNT_UNIT)
        return BigDecimal(totalWinningAmount).divide(totalPurchaseAmount, 2, RoundingMode.DOWN)
    }

    fun getRanking(lottoNumbers: LottoNumbers): LottoRanking {
        val matchCount = lottoNumbers.count { winningNumbers.contains(it) }
        val matchBonus = lottoNumbers.any { it == bonusLottoNumber }
        return LottoRanking.valueOf(matchCount, matchBonus)
    }
}
