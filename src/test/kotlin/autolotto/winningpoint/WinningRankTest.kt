package autolotto.winningpoint

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningRankTest : FunSpec({
    test("보너스번호 포함하여 5개 맞췄으면 2등") {
        // Given
        val matchingCount = 5
        val matchingBonusNumber = true

        // When
        val winningRank = WinningRank.from(matchingCount, matchingBonusNumber)

        // Then
        winningRank shouldBe WinningRank.SECOND
    }

    test("보너스번호 포함하지 않고 5개 맞췄으면 3등") {
        // Given
        val matchingCount = 5
        val matchingBonusNumber = false

        // When
        val winningRank = WinningRank.from(matchingCount, matchingBonusNumber)

        // Then
        winningRank shouldBe WinningRank.THIRD
    }
})
