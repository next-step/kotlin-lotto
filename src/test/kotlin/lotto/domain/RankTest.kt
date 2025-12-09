package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class RankTest : FreeSpec({

    "3개가 일치하면 5등이 나온다." {
        val rank = Rank.valueOf(3)
        rank shouldBe Rank.FIFTH
    }
    "2개가 일치하면 미스가 나온다." {
        val rank = Rank.valueOf(2)
        rank shouldBe Rank.MISS
    }
    "5개가 일치하고 보너스 번호가 있으면 2등이 나온다." {
        val rank = Rank.valueOf(5, hasBonus = true)
        rank shouldBe Rank.SECOND
    }
    "5개가 일치하고 보너스 번호가 없으면 3등이 나온다." {
        val rank = Rank.valueOf(5, hasBonus = false)
        rank shouldBe Rank.THIRD
    }
})
