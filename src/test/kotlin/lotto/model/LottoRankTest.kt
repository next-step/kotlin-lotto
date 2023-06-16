package lotto.model

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.Tuple3
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import lotto.model.LottoRank.Companion.totalPrize

@DisplayName("로또 순위")
class LottoRankTest : StringSpec({

    "매칭 개수와 보너스 일치 여부에 따른 로또 순위" {
        listOf(
            Tuple3(6, false, LottoRank.FIRST),
            Tuple3(5, true, LottoRank.SECOND),
            Tuple3(5, false, LottoRank.THIRD),
            Tuple3(4, true, LottoRank.FOURTH),
            Tuple3(3, true, LottoRank.FIFTH),
            Tuple3(2, true, LottoRank.MISS),
            Tuple3(0, true, LottoRank.MISS),
        ).forAll {
            LottoRank.rankOf(it.a, it.b) shouldBe it.c
        }
    }

    "매칭되는 개수나 보너스 조건이 없으면 예외" {
        listOf(
            7 to false,
            6 to true,
            Int.MAX_VALUE to false
        ).forAll {
            shouldThrowExactly<IllegalArgumentException> { LottoRank.rankOf(it.first, it.second) }
        }
    }

    "로또 당첨금 조회" {
        listOf(
            LottoRank.FIRST to 2_000_000_000,
            LottoRank.SECOND to 30_000_000,
            LottoRank.THIRD to 1_500_000,
            LottoRank.FOURTH to 50_000,
            LottoRank.FIFTH to 5_000,
            LottoRank.MISS to 0,
        ).forAll {
            it.first.prize shouldBe it.second
        }
    }

    "로또 상금 총액 계산" {
        listOf(
            listOf(LottoRank.FIRST, LottoRank.FIRST) to 4_000_000_000L,
            listOf(LottoRank.FIRST, LottoRank.SECOND) to 2_030_000_000L,
            listOf(LottoRank.SECOND, LottoRank.THIRD) to 31_500_000L,
            listOf(LottoRank.FOURTH, LottoRank.FOURTH) to 100_000L,
        ).forAll {
            it.first.totalPrize shouldBe it.second
        }
    }
})
