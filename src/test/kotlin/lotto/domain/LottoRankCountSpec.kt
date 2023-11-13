package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoRankCountSpec : FunSpec({
    context("로또 랭킹별 티켓 수에 대한 상금 합산") {
        test("2등에 한 장이 당첨되었을 경우 당첨금은 30_000_000 이다") {
            val rankCount = mapOf(LottoRank.SECOND to 1).let(::LottoRankCounts)

            rankCount.totalEarningMoney.value shouldBe 30_000_000
        }
        test("3등에 한 장이 당첨되었을 경우 당첨금은 1_500_000이다") {
            val rankCount = mapOf(LottoRank.THIRD to 1).let(::LottoRankCounts)

            rankCount.totalEarningMoney.value shouldBe 1_500_000
        }
        test("2등에 한 장, 3등에 두 장이 당첨되었을 경우 당첨금은 2_000_000_000이다") {
            val rankCount = mapOf(LottoRank.SECOND to 1, LottoRank.THIRD to 2).let(::LottoRankCounts)

            rankCount.totalEarningMoney.value shouldBe 33_000_000
        }
    }
})
