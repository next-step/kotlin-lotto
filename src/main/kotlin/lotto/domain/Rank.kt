package lotto.domain

class Rank {
    var ranks = mapOf<Int, Int>(3 to 0, 4 to 0, 5 to 0, 6 to 0)
        private set

    fun joinRank(rank: Int) {
        val changeRank = ranks.toMutableMap()
        if (rank >= 3) {
            changeRank[rank] = changeRank.getValue(rank) + 1
        }
        ranks = changeRank
    }
}
