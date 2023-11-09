package lotto.domain

class Lotto(lotto: List<Int>) {

    var lotto: List<Int> = lotto
        private set

    fun getMatchLottoCount(jackpotNumbers: Lotto): Int {
        return lotto.count { jackpotNumbers.lotto.contains(it) }
    }
}
