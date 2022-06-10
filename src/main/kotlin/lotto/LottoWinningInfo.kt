package lotto

import lotto.LottoWinningHandler.matchCount

class LottoWinningInfo(winningNumberInput: String, bonusNumberInput: String) {
    var winningNumbers = mutableListOf<Int>()
    var bonusNumber: Int = 0
    var scoreInfos = mutableListOf<ScoreInfo>()
    var revenue = 0

    init {
        require(winningNumberInput.contains(","))

        winningNumbers = winningNumberInput.split(",").map { it.replace(" ", "").toInt() }.toMutableList()
        bonusNumber = bonusNumberInput.toInt()

        require(winningNumbers.size == LOTTO_NUMBER_COUNT)
        require(LOTTO_NUMBER_RANGE.contains(bonusNumber) && !winningNumbers.contains(bonusNumber))
    }

    fun setScore(issuedLottos: List<List<Int>>) {
        val matchNumberMap = matchCount(issuedLottos, winningNumbers)
        val matchedFiveNumber = matchNumberMap.any { it.key == 5 && it.value > 0 }

        scoreInfos = matchNumberMap.filter { it.key > 0 }.map {
            ScoreInfo(it.key, getPrice(it.key), it.value)
        }.toMutableList()

        if (matchedFiveNumber) {
            matchCount(issuedLottos, listOf(bonusNumber)).filter { it.key > 0 && it.value > 0 }.map {
                scoreInfos.add(ScoreInfo(7, getPrice(7), it.value))
            }
        }
        revenue = LottoWinningHandler.calculateRevenue(scoreInfos)
    }

    fun getRevenuePercentage(amount: Int, revenue: Int): Double {
        return (revenue / amount).toDouble()
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = (1..45)
    }
}

class ScoreInfo(val match: Int, val price: Int, val count: Int)
