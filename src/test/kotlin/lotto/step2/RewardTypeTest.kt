package lotto.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step2.domain.RewardType

class RewardTypeTest : FunSpec({
    test("RewardType.of는 matchCount에 따라 올바른 RewardType을 반환한다") {
        // given, when & then
        RewardType.of(6) shouldBe RewardType.FIRST
        RewardType.of(5) shouldBe RewardType.SECOND
        RewardType.of(4) shouldBe RewardType.THIRD
        RewardType.of(3) shouldBe RewardType.FOURTH
        RewardType.of(2) shouldBe RewardType.FIFTH
        RewardType.of(1) shouldBe RewardType.SIXTH
        RewardType.of(0) shouldBe RewardType.NONE
    }

    test("RewardType.of는 유효하지 않은 matchCount에 대해 예외를 던진다") {
        // given
        val invalidMatchCount = -1

        // when & then
        val exception =
            shouldThrow<IllegalArgumentException> {
                RewardType.of(invalidMatchCount)
            }
        exception.message shouldBe "일치하는 RewardType이 없습니다. [matchCount=$invalidMatchCount]"
    }

    test("RewardType의 각 값에 대해 matchCount와 winningAmount가 올바르게 설정되어 있다") {
        // given & when & then
        RewardType.FIRST.matchCount shouldBe 6
        RewardType.FIRST.winningAmount shouldBe 2_000_000_000

        RewardType.SECOND.matchCount shouldBe 5
        RewardType.SECOND.winningAmount shouldBe 1_500_000

        RewardType.THIRD.matchCount shouldBe 4
        RewardType.THIRD.winningAmount shouldBe 50_000

        RewardType.FOURTH.matchCount shouldBe 3
        RewardType.FOURTH.winningAmount shouldBe 5_000

        RewardType.FIFTH.matchCount shouldBe 2
        RewardType.FIFTH.winningAmount shouldBe 0

        RewardType.SIXTH.matchCount shouldBe 1
        RewardType.SIXTH.winningAmount shouldBe 0

        RewardType.NONE.matchCount shouldBe 0
        RewardType.NONE.winningAmount shouldBe 0
    }
})
