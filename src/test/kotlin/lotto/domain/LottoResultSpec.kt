package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoResultSpec : FunSpec({
    test("로또 결과에 대한 총 상금액을 구한다") {
        val rankCount = mapOf(
            LottoRank.FIRST to 1,
            LottoRank.SECOND to 1,
            LottoRank.THIRD to 2,
            LottoRank.FOURTH to 1,
            LottoRank.FIFTH to 1,
            LottoRank.MISS to 2,
        )
        val result = rankCount.let(::LottoResult)
        val expect =
            LottoRank.FIRST.winningMoney * 1 + LottoRank.SECOND.winningMoney * 1 + LottoRank.THIRD.winningMoney * 2 + LottoRank.FOURTH.winningMoney * 1 + LottoRank.FIFTH.winningMoney * 1

        result.totalPrize shouldBe expect
    }
})
