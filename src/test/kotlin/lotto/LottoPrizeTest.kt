package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class LottoPrizeTest : FunSpec({
    test("번호가 5개 일치하고 보너스 번호가 일치하면 2등이다.") {
        // given
        val matchResult = LottoMatchResult(matchCount = 5, isBonusMatch = true)

        // when
        val result = LottoPrize.of(matchResult)

        // then
        result shouldBe LottoPrize.SECOND_PLACE
    }
})
