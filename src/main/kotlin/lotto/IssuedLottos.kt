package lotto

/**
 * 발급받은 로또를 표현하는 일급 컬렉션 입니다.
 *
 * 발급받은 로또가 다른 로또 번호와 얼마나 일치하는지 검사할 수 있습니다.
 */
class IssuedLottos(val lottos: List<Lotto>) {
    init {
        require(lottos.isNotEmpty()) { "lottos must not be empty" }
    }

    fun check(winningLotto: Lotto): LottoMatchResult {
        val matchCountGroup = lottos.map { it.match(winningLotto) }
            .groupBy { matchCount ->
                matchCount
            }
        return LottoMatchResult(
            threeMatchCount = matchCountGroup.getOrDefault(3, listOf()).size,
            fourMatchCount = matchCountGroup.getOrDefault(4, listOf()).size,
            fiveMatchCount = matchCountGroup.getOrDefault(5, listOf()).size,
            sixMatchCount = matchCountGroup.getOrDefault(6, listOf()).size,
        )
    }
}

data class LottoMatchResult(
    val threeMatchCount: Int,
    val fourMatchCount: Int,
    val fiveMatchCount: Int,
    val sixMatchCount: Int,
)
