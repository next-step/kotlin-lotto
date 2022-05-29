package lotto

import lotto.LottoWinningHandler.matchCount

class LottoWinningInfo(winningNumberInput: String) {
    var winningNumbers = mutableListOf<Int>()
    lateinit var scoreInfos: List<ScoreInfo>
    var revenue: Int = 0

    init {
        require(winningNumberInput.contains(","))
        winningNumbers = winningNumberInput.split(",").map { it.toInt() }.toMutableList()

        require(winningNumbers.size == 6)
    }

    fun setScore(issuedLottos: List<List<Int>>) {
        scoreInfos = matchCount(issuedLottos, winningNumbers).filter { it.value > 0 }.map {
            ScoreInfo(it.key, getPrice(it.key), it.value)
        }
    }
}

class ScoreInfo(val match: Int, val price: Int, val count: Int)
