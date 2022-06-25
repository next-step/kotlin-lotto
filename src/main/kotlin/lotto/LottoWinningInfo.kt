package lotto

class LottoWinningInfo(winningNumberInput: String, bonusNumberInput: String) {
    var winningLottoTicket: WinningLottoTicket
    var bonusNumber: Int = 0
    var scoreInfos = mutableListOf<ScoreInfo>()
    var revenue = 0

    init {
        val winningNumbers = winningNumberInput.split(",").map { it.replace(" ", "").toInt() }.map(::LottoNumber)
        winningLottoTicket = WinningLottoTicket(winningNumbers, LottoNumber(bonusNumberInput.toInt()))
    }

    fun setScore(issuedLottos: List<LottoTicket>) {
        val matchNumberMap = winningLottoTicket.matchCount(issuedLottos)

        val filtered = matchNumberMap.countMap.filter { (winningNumber) -> winningNumber.number > 0 }
        scoreInfos = setScoreInfos(filtered, null)

        val enableBonus = matchNumberMap.countMap.any { (winningNumber, count) -> winningNumber.number == WinningPriceEnum.FIVE.number && count > 0 }

        if (enableBonus) {
            val bonusFiltered = winningLottoTicket.matchBonus(issuedLottos).countMap.filter { (winningNumber, count) -> winningNumber.number > 0 && count > 0 }
            val bonusList = setScoreInfos(bonusFiltered, WinningPriceEnum.FIVE_BONUS)
            scoreInfos.addAll(bonusList)
        }

        revenue = winningLottoTicket.calculateRevenue(scoreInfos)
    }

    fun getRevenuePercentage(amount: Int, revenue: Int): Double {
        return (revenue / amount).toDouble()
    }

    private fun setScoreInfos(filtered: Map<WinningPriceEnum, Int>, magicNumber: WinningPriceEnum?): MutableList<ScoreInfo> {
        return filtered.filter { (winningNumber) -> winningNumber != WinningPriceEnum.ZERO }.map { (winningNumber, count) ->
            ScoreInfo(magicNumber ?: winningNumber, getPrice(magicNumber ?: winningNumber), count)
        }.toMutableList()
    }
}

class ScoreInfo(val match: WinningPriceEnum, val price: Int, val count: Int)
