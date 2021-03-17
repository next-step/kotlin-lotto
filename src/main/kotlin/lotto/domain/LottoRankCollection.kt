package lotto.domain

class LottoRankCollection(val rankCount: Map<Rank, Int>) {
    val sumAmount: Long
        get() = rankCount.entries
            .sumByLong { (it.key.amount).toLong() * (it.value).toLong() }

    private inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
        var sum = 0L
        for (element in this) {
            sum += selector(element)
        }
        return sum
    }
}
