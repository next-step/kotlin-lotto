package lotto.domain

data class Lotteries(val elements: List<Lotto>) {

    constructor(numberOfTickets: Int, generatingFunction: () -> Set<Int>) : this(
        List(numberOfTickets) { Lotto(generatingFunction()) }
    )

    fun count() = elements.size

    fun forEach(lambda: (lotto: Lotto) -> Unit) = elements.forEach { lambda(it) }

    fun <T> groupBy(lambda: (lotto: Lotto) -> T) = elements.groupBy(lambda).mapValues { Lotteries(it.value) }
}
