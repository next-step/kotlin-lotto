package lotto.model

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.model.LottoRank.Companion.totalPrize

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

    "로또 상금 총액 계산" {
        listOf(
            listOf(LottoRank.FIRST, LottoRank.FIRST) to 4_000_000_000L,
            listOf(LottoRank.FIRST, LottoRank.SECOND) to 2_001_500_000L,
            listOf(LottoRank.SECOND, LottoRank.THIRD) to 1_550_000L,
            listOf(LottoRank.FOURTH, LottoRank.FOURTH) to 10_000L,
        ).forAll {
            it.first.totalPrize shouldBe it.second
        }
    }
})
