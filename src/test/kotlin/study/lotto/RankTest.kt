package study.lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.lotto.model.Rank

/**
 * @author 이상준
 */
class RankTest: StringSpec({
    "Rank SECOND 테스트" {
        val second = Rank.findPrize(5, true)

        second shouldBe Rank.SECOND
    }
    "Rank THIRD 테스트" {
        val third = Rank.findPrize(5, false)

        third shouldBe Rank.THIRD
    }
})
