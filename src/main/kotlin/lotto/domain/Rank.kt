package lotto.domain

class Rank {
    var ranks = mapOf<String, Int>("5등" to 0, "4등" to 0, "3등" to 0,"2등" to 0, "1등" to 0)
        private set

    fun joinRank(rank: String) {
        val changeRank = ranks.toMutableMap()
        if (rank != "No Rank") {
            changeRank[rank] = changeRank.getValue(rank) + 1
        }
        ranks = changeRank
    }
}
