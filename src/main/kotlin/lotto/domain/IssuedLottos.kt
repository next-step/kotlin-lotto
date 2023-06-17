package lotto.domain

/**
 * ### 발급받은 로또를 표현하는 일급 컬렉션 입니다.
 *
 * 발급받은 로또가 다른 로또 번호와 얼마나 일치하는지 검사할 수 있습니다.
 */
class IssuedLottos(val lottos: List<Lotto>) {
    init {
        require(lottos.isNotEmpty()) { "lottos must not be empty" }
    }

    fun check(winningLotto: Lotto): LottoMatchStat {
        val matchCountGroup = lottos.map { it.match(winningLotto) }
            .groupBy { matchCount ->
                matchCount
            }
        return LottoMatchStat(
            threeMatchCount = matchCountGroup.getOrDefault(3, listOf()).size,
            fourMatchCount = matchCountGroup.getOrDefault(4, listOf()).size,
            fiveMatchCount = matchCountGroup.getOrDefault(5, listOf()).size,
            sixMatchCount = matchCountGroup.getOrDefault(6, listOf()).size,
        )
    }
}

/**
 * ### 로또의 당첨 통계를 표현하는 클래스 입니다.
 *
 * 당첨 통계를 토대로 구입 금액 대비 수익률을 계산할 수 있습니다.
 */
data class LottoMatchStat(
    val threeMatchCount: Int,
    val fourMatchCount: Int,
    val fiveMatchCount: Int,
    val sixMatchCount: Int,
) {
    fun calculateEarningsRate(seedMoney: Int): Double {
        val winningAmount = threeMatchCount * 5_000 +
            fourMatchCount * 50_000 +
            fiveMatchCount * 1_500_000 +
            sixMatchCount * 2_000_000_000
        return winningAmount.toDouble() / seedMoney
    }
}
