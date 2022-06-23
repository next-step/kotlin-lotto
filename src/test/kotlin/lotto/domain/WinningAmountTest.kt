package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.WinningAmount.FIFTH
import lotto.domain.WinningAmount.FIRST
import lotto.domain.WinningAmount.FOURTH
import lotto.domain.WinningAmount.MISS
import lotto.domain.WinningAmount.SECOND
import lotto.domain.WinningAmount.THIRD

internal class WinningAmountTest : FreeSpec({

    "매칭 개수와 보너스 여부에 해당되는 등수를 반환한다." - {
        listOf(
            row(6, true, FIRST),
            row(6, false, FIRST),
            row(5, true, SECOND),
            row(5, false, THIRD),
            row(4, true, FOURTH),
            row(4, false, FOURTH),
            row(3, true, FIFTH),
            row(3, false, FIFTH),
            row(2, true, MISS),
            row(2, false, MISS),
            row(1, true, MISS),
            row(1, false, MISS),
            row(0, true, MISS),
            row(0, false, MISS),
        ).forEach { (matchCount, matchBonus, result) ->
            "$matchCount + $matchBonus 의 등수는 ${result.name} 이다." {
                WinningAmount.findByMatchCount(matchCount = matchCount, matchBonus = matchBonus) shouldBe result
            }
        }
    }
})
