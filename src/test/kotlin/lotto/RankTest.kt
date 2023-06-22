package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

internal class RankTest : StringSpec({
    "일치하는 번호와 보너스볼 일치여부가 동일한 Rank 가 있다면 반환한다" {
        table(
            headers("matchCount", "matchBonus", "rank"),
            row(3, false, Rank.FOURTH),
            row(4, false, Rank.THIRD),
            row(5, false, Rank.SECOND),
            row(5, true, Rank.SECOND_WITH_BONUS),
            row(6, false, Rank.FIRST),
        ).forAll { matchCount, matchBonus, rank ->
            Rank.of(matchCount, matchBonus) shouldBe rank
        }
    }
})
