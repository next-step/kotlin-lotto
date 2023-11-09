package lotto.domain

class Lottery(
    private val lottoList: List<Lotto>
) {
    fun getCount() = lottoList.count()

    fun getNumberList() = lottoList.map { it.numbers }

    fun groupingByRank(keySelector: (Lotto) -> Rank) = lottoList.groupingBy(keySelector)
}
