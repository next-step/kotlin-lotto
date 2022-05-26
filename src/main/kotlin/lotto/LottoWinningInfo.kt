package lotto

class LottoWinningInfo(val winningNumberInfo: String) {

    fun getWinningNumbers(): List<Int> {
        return winningNumberInfo.split(",").map { it.toInt() }
    }
}