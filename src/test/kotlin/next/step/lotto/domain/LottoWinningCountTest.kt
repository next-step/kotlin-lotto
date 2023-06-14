package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoWinningCountTest : DescribeSpec({
    describe("LottoWinningCount 조회") {
        context("당첨개수에 따라 일치하는 LottoWinningCount 제공") {
            data class CountExpected(val matchingCount: Int, val expected: LottoWinningCount)
            withData(
                CountExpected(0, LottoWinningCount.NONE),
                CountExpected(1, LottoWinningCount.NONE),
                CountExpected(2, LottoWinningCount.NONE),
                CountExpected(3, LottoWinningCount.THREE),
                CountExpected(4, LottoWinningCount.FOUR),
                CountExpected(5, LottoWinningCount.FIVE),
                CountExpected(6, LottoWinningCount.SIX)
            ) { (matchingCount, expected) ->
                LottoWinningCount.from(matchingCount) shouldBe expected
            }
        }
    }

})
