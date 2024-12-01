package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoResultTest : StringSpec({

    "로또 결과를 생성할 수 있다" {
        // Arrange:
        val lottoRank = LottoRank.FIRST
        val count = Count.zero()

        // Act:
        val lottoResult = LottoResult(lottoRank, count)

        // Assert:
        lottoResult.lottoRank shouldBe lottoRank
    }

    "당첨자가 추가되면 로또 결과 개수가 증가한다" {
        // Arrange:
        val lottoResult = LottoResult(LottoRank.FIRST, Count.zero())

        // Act:
        val result = lottoResult.plus()

        // Assert:
        result.count shouldBe Count(1)
    }

    "로또 결과의 sum은 개수 x 로또 상금의 결과이다" {
        // Arrange:
        val lottoResult = LottoResult(LottoRank.FIRST, Count(1))

        // Act:
        val result = lottoResult.sum()

        // Assert:
        result shouldBe 2_000_000_000
    }
})
