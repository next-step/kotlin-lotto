package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class LottoNumbersTest {

    @Test
    fun `로또 번호들을 지난 주 당첨번호와 비교해서 각 등수별 개수를 알 수 있다`() {
        val lottoNumbers = LottoNumbers((1..6).map { LottoNumber((it..it + 5).toList()) })
        val winLottoNumber = LottoNumber((1..6).toList())

        val result = lottoNumbers.makeRankingCountMap(winLottoNumber)

        result[LottoRanking.ONE_ST] shouldBe 1
        result[LottoRanking.TWO_ND] shouldBe 1
        result[LottoRanking.THREE_RD] shouldBe 1
        result[LottoRanking.FOUR_TH] shouldBe 1
        result[LottoRanking.OUT_OF_RAKING] shouldBe 2
    }

    @Test
    fun `로또 번호들을 지난 주 당첨번호와 비교해서 총 수익률을 계산할 수 있다`() {
        val lottoNumbers = LottoNumbers((1..14).map { LottoNumber((it..it + 5).toList()) })
        val winLottoNumber = LottoNumber(listOf(17, 18, 19, 20, 21, 22))

        val result = lottoNumbers.getRevenueRate(winLottoNumber)

        result shouldBe BigDecimal("0.35")
    }
}
