package lotto

import io.kotest.matchers.shouldBe
import lotto.domain.LottoRank
import lotto.view.LottoResult
import org.junit.jupiter.api.Test

class LottoResultTest {
    @Test
    fun `당첨 순위가 4등일 때 당첨금은 5000이다`() {
        val lottoResult = LottoResult(listOf(LottoRank.FOURTH))
        val totalMoney = lottoResult.rankCounts.map { (prize, count) -> count * prize.money }.sum()
        totalMoney shouldBe 5000
    }

    @Test
    fun `당첨 순위가 3등일 때 당첨금은 50000이다`() {
        val lottoResult = LottoResult(listOf(LottoRank.THIRD))
        val totalMoney = lottoResult.rankCounts.map { (prize, count) -> count * prize.money }.sum()
        totalMoney shouldBe 50000
    }

    @Test
    fun `당첨 순위가 2등일 때 당첨금은 1_500_000이다`() {
        val lottoResult = LottoResult(listOf(LottoRank.SECOND))
        val totalMoney = lottoResult.rankCounts.map { (prize, count) -> count * prize.money }.sum()
        totalMoney shouldBe 1_500_000
    }

    @Test
    fun `당첨 순위가 1등일 때 당첨금은 2_000_000_000`() {
        val lottoResult = LottoResult(listOf(LottoRank.FIRST))
        val totalMoney = lottoResult.rankCounts.map { (prize, count) -> count * prize.money }.sum()
        totalMoney shouldBe 2_000_000_000
    }
}
