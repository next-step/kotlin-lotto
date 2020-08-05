package lotto.domain

class Lotto(val prize: Prize) {
    var count: Int = 0
        private set

    fun addCount() {
        count++
    }

    fun getCountOfMatch(): Int {
        return prize.countOfMatch
    }

    fun getPrizeMoney(): Int {
        return prize.prizeMoney
    }
}
