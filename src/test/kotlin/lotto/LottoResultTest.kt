package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoResult
import lotto.domain.Reward

class LottoResultTest : StringSpec({
    "로또의 수익률을 계산한다." {
        val sut = LottoResult(
            mapOf(
                Reward.FIRST to 0,
                Reward.SECOND to 0,
                Reward.THIRD to 0,
                Reward.FOURTH to 0,
                Reward.FIFTH to 1,
                Reward.NONE to 4,
            )
        )

        val actual = sut.calculateRateOfReturn()

        actual shouldBe 1
    }

    "로또의 당첨금이 없다면 수익률은 0이다." {
        val sut = LottoResult(
            mapOf(
                Reward.FIRST to 0,
                Reward.SECOND to 0,
                Reward.THIRD to 0,
                Reward.FOURTH to 0,
                Reward.NONE to 5,
            )
        )

        val actual = sut.calculateRateOfReturn()

        actual shouldBe 0
    }

    "로또 결과 중 유효 보상을 반환한다." {
        val sut = LottoResult(
            mapOf(
                Reward.FIRST to 1,
                Reward.SECOND to 2,
                Reward.THIRD to 2,
                Reward.FOURTH to 3,
                Reward.NONE to 5,
            )
        )

        sut.winningRewards shouldBe mapOf(
            Reward.FIRST to 1,
            Reward.SECOND to 2,
            Reward.THIRD to 2,
            Reward.FOURTH to 3,
        )
    }
})
