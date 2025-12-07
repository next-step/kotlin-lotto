package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class RankTest : FreeSpec({

    "5개가 일치하면 3등이 나온다." {
        val rank = Rank.valueOf(5, false)
        rank shouldBe Rank.THIRD
    }
    "5개가 일치하고 보너스볼이 일치하면 2등이 나온다." {
        val rank = Rank.valueOf(5, true)
        rank shouldBe Rank.SECOND
    }
    "3개가 일치하면 5등이 나온다." {
        val rank = Rank.valueOf(3, false)
        rank shouldBe Rank.FIFTH
    }
    "2개가 일치하면 미스가 나온다." {
        val rank = Rank.valueOf(2, false)
        rank shouldBe Rank.MISS
    }
})
