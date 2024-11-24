package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : StringSpec({
    "로또의 수익률을 계산한다." {
        val sut = LottoResult(
            mapOf(
                Reward.FIRST to 0,
                Reward.SECOND to 0,
                Reward.THIRD to 0,
                Reward.FOURTH to 1,
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
})
