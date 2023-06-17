package lotto

import java.math.BigDecimal
import java.math.RoundingMode

class WinningLottoNumber(
    private val winningNumber: LottoNumber,
    private val bonusBallNumber: Int
) {

    init {
        require(LottoNumber.LOTTO_NUMBER_RANGE.contains(bonusBallNumber)) {
            "보너스 번호는 ${LottoNumber.LOTTO_START_NUMBER} ~ ${LottoNumber.LOTTO_END_NUMBER} 사이 값이어야 합니다."
        }
    }

    fun makeRankingCountMap(lottoNumbers: LottoNumbers): Map<LottoRanking, Int> = lottoNumbers.groupingBy {
        this.getRanking(it)
    }.eachCount()

    fun getRevenueRate(lottoNumbers: LottoNumbers): BigDecimal {
        val totalWinningAmount = lottoNumbers.sumOf { this.getRanking(it).winningAmount }
        val totalPurchaseAmount = BigDecimal(lottoNumbers.size * LottoStore.PURCHASE_AMOUNT_UNIT)
        return BigDecimal(totalWinningAmount).divide(totalPurchaseAmount, 2, RoundingMode.DOWN)
    }

    fun getRanking(lottoNumber: LottoNumber): LottoRanking {
        val matchCount = lottoNumber.count { winningNumber.contains(it) }
        val matchBonus = lottoNumber.any { it == bonusBallNumber }
        return LottoRanking.valueOf(matchCount, matchBonus)
    }
}
