package lotto.domain

class Lotto(val lotto: List<Int>) {

    fun getMatchLottoCount(jackpotNumbers: List<Int>): Int {
        return lotto.count { jackpotNumbers.contains(it) }
    }
}
