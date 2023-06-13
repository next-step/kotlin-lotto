package lotto.model

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

@DisplayName("로또 순위")
class LottoRankTest : StringSpec({

    "매칭 개수에 따른 로또 순위" {
        listOf(
            6 to LottoRank.FIRST,
            5 to LottoRank.SECOND,
            4 to LottoRank.THIRD,
            3 to LottoRank.FOURTH,
            2 to LottoRank.MISS,
            0 to LottoRank.MISS,
        ).forAll {
            LottoRank.rankOf(it.first) shouldBe it.second
        }
    }

    "매칭되는 개수가 없으면 예외" {
        listOf(7, Int.MAX_VALUE).forAll {
            shouldThrowExactly<IllegalArgumentException> { LottoRank.rankOf(it) }
        }
    }
})
