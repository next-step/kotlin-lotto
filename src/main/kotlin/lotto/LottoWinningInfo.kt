package lotto

import lotto.LottoWinningHandler.matchCount

class LottoWinningInfo(winningNumberInput: String) {
    var winningNumbers = mutableListOf<Int>()
    var scoreInfos: List<ScoreInfo> = mutableListOf()

    init {
        require(winningNumberInput.contains(","))
        winningNumbers = winningNumberInput.split(",").map { it.toInt() }.toMutableList()

        require(winningNumbers.size == 6)
    }

    fun setScore(issuedLottos: List<List<Int>>) {
        scoreInfos = matchCount(issuedLottos, winningNumbers).filter { it.key > 0 }.map {
            ScoreInfo(it.key, getPrice(it.key), it.value)
        }
    }
}

class ScoreInfo(val match: Int, val price: Int, val count: Int)
