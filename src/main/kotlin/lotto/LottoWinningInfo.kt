package lotto

import lotto.LottoWinningHandler.matchCount

class LottoWinningInfo(winningNumberInput: String, bonusNumberInput: String) {
    var winningNumbers = mutableListOf<LottoNumber>()
    var bonusNumber: Int = 0
    var scoreInfos = mutableListOf<ScoreInfo>()
    var revenue = 0

    init {
        winningNumbers = winningNumberInput.split(",").map { it.replace(" ", "").toInt() }.map(::LottoNumber).toMutableList()
        bonusNumber = bonusNumberInput.toInt()

        // todo keira. validate ticket
    }

    fun setScore(issuedLottos: List<LottoTicket>) {
        val matchNumberMap = matchCount(issuedLottos, winningNumbers)
        val matchedFiveNumber = matchNumberMap.any { (winningNumber, count) -> winningNumber.number == WinningPriceEnum.FIVE.number && count > 0 }

        val filtered = matchNumberMap.filter { (winningNumber) -> winningNumber.number > 0 }
        scoreInfos = setScoreInfos(filtered, null)

        if (matchedFiveNumber) {
            val bonusFiltered = matchCount(issuedLottos, listOf(LottoNumber(bonusNumber))).filter { (winningNumber, count) -> winningNumber.number > 0 && count > 0 }
            val bonusList = setScoreInfos(bonusFiltered, WinningPriceEnum.FIVE_BONUS.number)
            scoreInfos.addAll(bonusList)
        }
        revenue = LottoWinningHandler.calculateRevenue(scoreInfos)
    }

    fun getRevenuePercentage(amount: Int, revenue: Int): Double {
        return (revenue / amount).toDouble()
    }

    private fun setScoreInfos(filtered: Map<WinningPriceEnum, Int>, magicNumber: Int?): MutableList<ScoreInfo> {
        return filtered.filter { (winningNumber) -> winningNumber != WinningPriceEnum.ZERO }.map { (winningNumber, count) ->
            ScoreInfo(magicNumber ?: winningNumber.number, getPrice(magicNumber ?: winningNumber.number), count)
        }.toMutableList()
    }
}

class ScoreInfo(val match: Int, val price: Int, val count: Int)
