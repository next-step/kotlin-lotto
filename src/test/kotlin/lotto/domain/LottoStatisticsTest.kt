package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class LottoStatisticsTest : StringSpec({
    val lottoStatistics = LottoStatistics()
    val lottos = Lottos(
        listOf(
            Lotto(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))),
            Lotto(listOf(LottoNumber(7), LottoNumber(8), LottoNumber(9), LottoNumber(10), LottoNumber(11), LottoNumber(12)))
        )
    )
    val winningNumber = WinningNumber(
        Lotto(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(8))),
        LottoNumber(6)
    )


    "lottos를 분석하고 RankFactory를 반환해야 함" {
        val result = lottoStatistics.analyze(lottos, winningNumber)
        result should {
            it.getRankCount(Rank.FIRST) shouldBe 0
            it.getRankCount(Rank.SECOND) shouldBe 1
            it.getRankCount(Rank.THIRD) shouldBe 0
            it.getRankCount(Rank.FOURTH) shouldBe 0
            it.getRankCount(Rank.FIFTH) shouldBe 0
        }
    }

    "수익률을 계산해야 함" {
        val payment = Payment(10_000)
        val result = lottoStatistics.getProfitRate(payment)
        result shouldBe 0.0
    }
})
