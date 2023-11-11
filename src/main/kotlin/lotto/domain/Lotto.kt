package lotto.domain

class Lotto(val lotto: List<Int>) {

    fun getMatchLottoCount(jackpotNumbers: Lotto): Int {
        return lotto.count { jackpotNumbers.lotto.contains(it) }
    }
}
