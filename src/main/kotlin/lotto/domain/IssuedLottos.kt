package lotto.domain

/**
 * ### 발급받은 로또를 표현하는 일급 컬렉션 입니다.
 *
 * 발급받은 로또가 다른 로또 번호와 얼마나 일치하는지 검사할 수 있습니다.
 */
data class IssuedLottos(val lottos: List<Lotto>) {
    init {
        require(lottos.isNotEmpty()) { "lottos must not be empty" }
    }

    fun check(winningLotto: WinningLotto): IssuedLottoMatchResult {
        val lottoMatchResults: List<LottoMatchResult> = lottos.map { it.match(winningLotto) }
        return IssuedLottoMatchResult(lottoMatchResults)
    }

    override fun toString(): String {
        return lottos.joinToString("\n")
    }
}

/**
 * ### 발급받은 로또들의 당첨 결과를 표현하는 클래스 입니다.
 *
 * 당첨 결과를 토대로 구입 금액 대비 수익률을 계산할 수 있고 당첨 통계를 추출할 수 있습니다.
 */
data class IssuedLottoMatchResult(
    val lottoMatchResults: List<LottoMatchResult>,
) {
    val matchStat: IssuedLottoMatchStat by lazy {
        IssuedLottoMatchStat(
            countOfFifth = lottoMatchResults.filter { it.rank == LottoRank.FIFTH }.size,
            countOfFourth = lottoMatchResults.filter { it.rank == LottoRank.FOURTH }.size,
            countOfThird = lottoMatchResults.filter { it.rank == LottoRank.THIRD }.size,
            countOfSecond = lottoMatchResults.filter { it.rank == LottoRank.SECOND }.size,
            countOfFirst = lottoMatchResults.filter { it.rank == LottoRank.FIRST }.size,
        )
    }

    fun calculateEarningsRate(seedMoney: Int): Double {
        val winningMoneyTotal = lottoMatchResults.sumOf { it.rank.winningMoney }
        return winningMoneyTotal.toDouble() / seedMoney
    }
}

/**
 * ### 발급받은 로또들의 당첨 통계를 표현하는 클래스 입니다.
 */
data class IssuedLottoMatchStat(
    val countOfFifth: Int,
    val countOfFourth: Int,
    val countOfThird: Int,
    val countOfSecond: Int,
    val countOfFirst: Int,
)
