package lotto.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class RankTest : AnnotationSpec() {

    @Test
    fun `각 등수의 당첨금을 확인해본다`() {
        Rank.valueOf(3, false).winningMoney shouldBe 5_000
        Rank.valueOf(4, false).winningMoney shouldBe 50_000
        Rank.valueOf(5, false).winningMoney shouldBe 1_500_000
        Rank.valueOf(5, true).winningMoney shouldBe 30_000_000
        Rank.valueOf(6, false).winningMoney shouldBe 2_000_000_000
    }
}
