package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.LottoRank.FIRST
import lotto.LottoRank.FIFTH
import lotto.LottoRank.THIRD
import lotto.LottoRank.SECOND

class LottoRankTest : StringSpec({

    "로또 순위가 1등이면 2,000,000,000원을 반환한다" {
        // Arrange:
        val lottoRank = FIRST

        // Act:
        val result = lottoRank.sumPrice(Count(1))

        // Assert:
        result shouldBe 2_000_000_000
    }

    "맞춘 개수가 3개이고 보너스 번호를 맞추지 않았을 때 로또 순위는 FIFTH이다" {
        // Arrange:
        val matchCount = 3

        // Act:
        val result = LottoRank.valueOf(matchCount, false)

        // Assert:
        result shouldBe FIFTH
    }

    "맞춘 개수가 5개이고 보너스 번호를 맞추지 않았을 때 로또 순위는 THIRD이다" {
        // Arrange:
        val matchCount = 5

        // Act:
        val result = LottoRank.valueOf(matchCount, false)

        // Assert:
        result shouldBe THIRD
    }

    "맞춘 개수가 5개이고 보너스 번호를 맞추었을 때 로또 순위는 SECOND이다" {
        // Arrange:
        val matchCount = 5

        // Act:
        val result = LottoRank.valueOf(matchCount, true)

        // Assert:
        result shouldBe SECOND
    }

    "맞춘 개수가 6개이면 로또 순위는 FIRST이다" {
        // Arrange:
        val matchCount = 6

        // Act:
        val result = LottoRank.valueOf(matchCount, false)

        // Assert:
        result shouldBe FIRST
    }
})
