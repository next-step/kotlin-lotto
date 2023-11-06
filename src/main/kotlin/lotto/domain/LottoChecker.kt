package lotto.domain

class LottoChecker() {
    fun getWinNum(lotto: Lotto, winningNumbers: List<Int>): Int {
        val lottoNums = lotto.numbers
        return lottoNums.intersect(winningNumbers).size
    }
}
