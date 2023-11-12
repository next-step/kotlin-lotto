package autolotto.winningpoint

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningRankTest : FunSpec({
    test("보너스번호 포함하여 5개 맞췄으면 2등") {
        // Given
        val matchingCount = 5
        val matchingBonusNumber = true

        // When
        val winningRank = WinningRank.of(matchingCount, matchingBonusNumber)

        // Then
        winningRank shouldBe WinningRank.SECOND
    }

    test("보너스번호 포함하지 않고 5개 맞췄으면 3등") {
        // Given
        val matchingCount = 5
        val matchingBonusNumber = false

        // When
        val winningRank = WinningRank.of(matchingCount, matchingBonusNumber)

        // Then
        winningRank shouldBe WinningRank.THIRD
    }

    test("보너스번호 포함하고 6개 맞췄으면 1등") {
        // Given
        val matchingCount = 6
        val matchingBonusNumber = true

        // When
        val winningRank = WinningRank.of(matchingCount, matchingBonusNumber)

        // Then
        winningRank shouldBe WinningRank.FIRST
    }

    test("보너스번호 포함하지않고 6개 맞췄으면 1등") {
        // Given
        val matchingCount = 6
        val matchingBonusNumber = false

        // When
        val winningRank = WinningRank.of(matchingCount, matchingBonusNumber)

        // Then
        winningRank shouldBe WinningRank.FIRST
    }
})
