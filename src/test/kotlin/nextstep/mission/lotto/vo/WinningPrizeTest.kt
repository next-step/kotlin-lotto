package nextstep.mission.lotto.vo

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningPrizeTest : StringSpec({

    "FIRST: 당첨 조건 6이다." {
        WinningPrize.FIRST.matchedCount shouldBe 6
    }

    "FIRST: 당첨 금액은 20억이다." {
        WinningPrize.FIRST.prize shouldBe 2_000_000_000
    }

    "SECOND: 당첨 조건 5이다." {
        WinningPrize.SECOND.matchedCount shouldBe 5
    }

    "SECOND: 당첨 금액은 3000만이다." {
        WinningPrize.SECOND.prize shouldBe 30_000_000
    }

    "THIRD: 당첨 조건 5이다." {
        WinningPrize.THIRD.matchedCount shouldBe 5
    }

    "THIRD: 당첨 금액은 150만이다." {
        WinningPrize.THIRD.prize shouldBe 1_500_000
    }

    "THIRD: 당첨 조건 4이다." {
        WinningPrize.FOURTH.matchedCount shouldBe 4
    }

    "THIRD: 당첨 금액은 5만이다." {
        WinningPrize.FOURTH.prize shouldBe 50_000
    }

    "FOURTH: 당첨 조건 3이다." {
        WinningPrize.FIFTH.matchedCount shouldBe 3
    }

    "FOURTH: 당첨 금액은 5만이다." {
        WinningPrize.FIFTH.prize shouldBe 5_000
    }

    "당첨 조건에 맞는 당첨 상금을 조회할 수 있다. 당첨 상금을 찾지 못하면 null을 반환한다." {
        listOf(
            row(6, false, WinningPrize.FIRST),
            row(6, true, WinningPrize.FIRST),
            row(5, true, WinningPrize.SECOND),
            row(5, false, WinningPrize.THIRD),
            row(4, false, WinningPrize.FOURTH),
            row(4, true, WinningPrize.FOURTH),
            row(3, false, WinningPrize.FIFTH),
            row(3, true, WinningPrize.FIFTH),
            row(-1, false, null),
            row(-1, true, null),
        ).forEach { (matchedCount, bonusMatched, winningPrize) ->
            WinningPrize.find(matchedCount, bonusMatched) shouldBe winningPrize
        }
    }
})
