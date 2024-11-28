package lotto.step3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step3.domain.Rank

class RankTest : FunSpec({
    test("Rank.valueOf는 (matchCount, hasBonusNumber)에 따라 올바른 Rank을 반환한다") {
        // given, when & then
        Rank.valueOf(matchCount = 6, hasBonusNumber = false) shouldBe Rank.FIRST
        Rank.valueOf(matchCount = 5, hasBonusNumber = true) shouldBe Rank.SECOND
        Rank.valueOf(matchCount = 5, hasBonusNumber = false) shouldBe Rank.THIRD
        Rank.valueOf(matchCount = 4, hasBonusNumber = false) shouldBe Rank.FOURTH
        Rank.valueOf(matchCount = 3, hasBonusNumber = false) shouldBe Rank.FIFTH
        Rank.valueOf(matchCount = 2, hasBonusNumber = false) shouldBe Rank.MISS
        Rank.valueOf(matchCount = 2, hasBonusNumber = true) shouldBe Rank.MISS
        Rank.valueOf(matchCount = 1, hasBonusNumber = false) shouldBe Rank.MISS
        Rank.valueOf(matchCount = 1, hasBonusNumber = true) shouldBe Rank.MISS
        Rank.valueOf(matchCount = 0, hasBonusNumber = false) shouldBe Rank.MISS
        Rank.valueOf(matchCount = 0, hasBonusNumber = true) shouldBe Rank.MISS
    }
    test("Rank의 각 값에 대해 matchCount와 winningAmount가 올바르게 설정되어 있다") {
        // given & when & then
        Rank.FIRST.matchCount shouldBe 6
        Rank.FIRST.hasBonusNumber shouldBe false
        Rank.FIRST.winningAmount shouldBe 2_000_000_000

        Rank.SECOND.matchCount shouldBe 5
        Rank.SECOND.hasBonusNumber shouldBe true
        Rank.SECOND.winningAmount shouldBe 30_000_000

        Rank.THIRD.matchCount shouldBe 5
        Rank.THIRD.hasBonusNumber shouldBe false
        Rank.THIRD.winningAmount shouldBe 1_500_000

        Rank.FOURTH.matchCount shouldBe 4
        Rank.FOURTH.hasBonusNumber shouldBe false
        Rank.FOURTH.winningAmount shouldBe 50_000

        Rank.FIFTH.matchCount shouldBe 3
        Rank.FIFTH.hasBonusNumber shouldBe false
        Rank.FIFTH.winningAmount shouldBe 5_000

        Rank.MISS.matchCount shouldBe 0
        Rank.MISS.hasBonusNumber shouldBe false
        Rank.MISS.winningAmount shouldBe 0
    }
})
