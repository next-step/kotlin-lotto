package lotto

import lotto.LottoWinningHandler.matchCount

class LottoWinningInfo(winningNumberInput: String, bonusNumberInput: String) {
    var winningNumbers = mutableListOf<Int>()
    var bonusNumber: Int = 0
    var scoreInfos = mutableListOf<ScoreInfo>()
    var revenue = 0

    init {
        winningNumbers = winningNumberInput.split(",").map { it.replace(" ", "").toInt() }.toMutableList()
        bonusNumber = bonusNumberInput.toInt()

        // todo keira. validate ticket
    }

    fun setScore(issuedLottos: List<LottoTicket>) {
        val matchNumberMap = matchCount(issuedLottos, winningNumbers)
        val matchedFiveNumber = matchNumberMap.any { (winningNumber, count) -> winningNumber.number == WinningPriceEnum.FIVE.number && count > 0 }

        val filtered = matchNumberMap.filter { (winningNumber, count) -> winningNumber.number > 0 }
        scoreInfos = setScoreInfos(filtered, null)

        if (matchedFiveNumber) {
            val bonusFiltered = matchCount(issuedLottos, listOf(bonusNumber)).filter { (winningNumber, count) -> winningNumber.number > 0 && count > 0 }
            val bonusList = setScoreInfos(bonusFiltered, WinningPriceEnum.FIVE_BONUS.number)
            scoreInfos.addAll(bonusList)
        }
        revenue = LottoWinningHandler.calculateRevenue(scoreInfos)
    }

    fun getRevenuePercentage(amount: Int, revenue: Int): Double {
        return (revenue / amount).toDouble()
    }

    private fun setScoreInfos(filtered: Map<WinningPriceEnum, Int>, magicNumber: Int?): MutableList<ScoreInfo> {
        return filtered.filter { (winningNumber, count) -> winningNumber != WinningPriceEnum.ZERO }.map { (winningNumber, count) ->
            ScoreInfo(magicNumber ?: winningNumber.number, getPrice(magicNumber ?: winningNumber.number), count)
        }.toMutableList()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
    }
}

class ScoreInfo(val match: Int, val price: Int, val count: Int)
