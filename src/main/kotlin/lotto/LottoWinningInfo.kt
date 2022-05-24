package lotto

class LottoWinningInfo(val winningNumberInfo: String) {

    fun getWinningNumbers(): List<String> {
        return winningNumberInfo.split(",")
    }
}