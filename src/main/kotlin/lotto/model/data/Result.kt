package lotto.model.data

data class Result(val lotto: Lotto, val winning: Winning)
data class Results(val resultList: List<Result>) : List<Result> by resultList {

    fun toWinningCountMap(): Map<Winning, Int> {
        return Winning.values()
            .associateWith { winning -> this.countOf(winning) }
            .toSortedMap { o1, o2 -> o1.winMoney - o2.winMoney }
    }

    private fun countOf(winning: Winning) = this.count { it.winning == winning }
}
