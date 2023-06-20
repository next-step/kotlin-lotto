package lotto.domain

enum class Rank(
    val title: String,
    val amount: Long,
    private val matchCount: Int,
    var count: Int
) {
    MATCH_THREE("3개 일치", 5000, 3, 0),
    MATCH_FOUR("4개 일치", 50000, 4, 0),
    MATCH_FIVE("5개 일치", 1500000, 5, 0),
    MATCH_SIX("6개 일치", 2000000000, 6, 0);

    fun getRank(lottos: Lottos, winnerNumbers: List<LottoNumber>): Rank {
        count = lottos.lottoNumbers.count { lottoNumbers ->
            lottoNumbers.lottoNumbers.intersect(winnerNumbers.toSet()).count() == matchCount
        }
        return this
    }
}
