package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.WinningAmount.FIRST
import lotto.domain.WinningAmount.FOURTH
import lotto.domain.WinningAmount.MISS
import lotto.domain.WinningAmount.SECOND
import lotto.domain.WinningAmount.THIRD

internal class WinningAmountTest : FreeSpec({

    "매칭 개수에 해당되는 등수를 반환한다." - {
        listOf(
            row(6, FIRST),
            row(5, SECOND),
            row(4, THIRD),
            row(3, FOURTH),
            row(2, MISS),
            row(1, MISS),
            row(0, MISS),
        ).forEach { (matchCount, result) ->
            "$matchCount 의 등수는 ${result.name} 이다." {
                WinningAmount.findByMatchCount(matchCount = matchCount) shouldBe result
            }
        }
    }
})
