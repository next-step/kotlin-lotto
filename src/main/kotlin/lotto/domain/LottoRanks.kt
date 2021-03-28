package lotto.domain

data class LottoRanks(private val rankCount: Map<Rank, Int>) : Map<Rank, Int> by rankCount {
    val sumAmount: Long
        get() = rankCount.entries
            .sumByLong { (it.key.amount) * (it.value).toLong() }

    private inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
        var sum = 0L
        for (element in this) {
            sum += selector(element)
        }

        return sum
    }
}
