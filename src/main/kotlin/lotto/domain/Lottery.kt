package lotto.domain

class Lottery(
    val lottoList: List<Lotto>
) {
    fun getCount() = lottoList.count()

    fun groupingByRank(keySelector: (Lotto) -> Rank) = lottoList.groupingBy(keySelector)

    override fun toString(): String = lottoList.joinToString("\n")
}
