package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoResultChecker {
    fun check(lottos: List<Lotto>, winningNumbers: WinningNumbers): LottoResults {
        return LottoResults(emptyList())
    }

}

class LottoResults(ranks: List<LottoRank>) {
    val resultCountByRank: Map<LottoRank, Int> = ranks.groupingBy { it }.eachCount()
}

enum class LottoRank(private val matchCount: Int, private val prizeAmount: Long) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
}

class LottoResultsCheckerTest {
    @Test
    fun `구매한 로또 목록과 당첨 번호를 비교해서 등수 별 개수를 기록한다`() {
        val firstPrize = listOf(1, 2, 3, 4, 5, 6)
        val lottos = listOf(
            Lotto(firstPrize),
            Lotto(listOf(1, 2, 3, 4, 5, 45)),
            Lotto(listOf(1, 2, 3, 4, 44, 45)),
            Lotto(listOf(1, 2, 3, 43, 44, 45)),
            Lotto(listOf(1, 2, 42, 43, 44, 45)),
            Lotto(listOf(1, 41, 42, 43, 44, 45)),
            Lotto(listOf(40, 41, 42, 43, 44, 45)),
        )
        val winningNumbers = WinningNumbers(firstPrize)
        val lottoResultChecker = LottoResultChecker()

        val lottoResults = lottoResultChecker.check(lottos, winningNumbers)

        val expected = mapOf(LottoRank.FIRST to 1, LottoRank.FIRST to 1, LottoRank.SECOND to 1, LottoRank.THIRD to 1, LottoRank.FORTH to 1)
        assertThat(lottoResults.resultCountByRank).isEqualTo(expected)
    }
}