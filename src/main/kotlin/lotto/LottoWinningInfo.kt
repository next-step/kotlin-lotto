package lotto

class LottoWinningInfo(val winningNumberInfo: String) {

    fun getWinningNumbers(): List<Int> {
        require(winningNumberInfo.contains(","))

        val splitted = winningNumberInfo.split(",")
        require(splitted.size == 6)

        return splitted.map { it.toInt() }
    }
}