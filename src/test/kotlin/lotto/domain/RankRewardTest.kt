package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import lotto.domain.RankReward.FIFTH
import lotto.domain.RankReward.FIRST
import lotto.domain.RankReward.FOURTH
import lotto.domain.RankReward.MISS
import lotto.domain.RankReward.SECOND
import lotto.domain.RankReward.THIRD

class RankRewardTest : StringSpec({
    "매칭 로또 넘버 숫자와 보너스에 따라 랭크를 반환한다" {
        table(
            headers("matchedCount", "matchBonus", "expected"),
            row(6, false, FIRST),
            row(5, true, SECOND),
            row(5, false, THIRD),
            row(4, true, FOURTH),
            row(4, false, FOURTH),
            row(3, true, FIFTH),
            row(3, false, FIFTH),
            row(2, true, MISS),
            row(1, true, MISS),
        ).forAll { matchedCount, matchBonus, expected ->
            RankReward.valueOf(matchedCount = matchedCount, matchBonus = matchBonus) shouldBe expected
        }
    }

    "잘못된 조건을 전달하면 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            RankReward.valueOf(
                matchedCount = -10,
                matchBonus = true,
            )
        }
    }
})
