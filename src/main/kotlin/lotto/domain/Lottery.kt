package lotto.domain

@JvmInline
value class Lottery(
    val lottoList: List<Lotto>
) {
    fun getCount() = lottoList.count()

    fun groupingByRank(keySelector: (Lotto) -> Rank) = lottoList.groupingBy(keySelector)
}
