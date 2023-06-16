package lotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.Tuple3
import io.kotest.core.spec.DisplayName
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

@DisplayName("로또 스코어")
class LottoScoreTest : StringSpec({

    "랭크들과 총 구매 금액으로 생성" {
        shouldNotThrowAny {
            LottoScore(listOf(LottoRank.MISS), 3000)
        }
    }

    "구매 금액은 반드시 0 또는 양수" {
        listOf(-1L, -10L, Long.MIN_VALUE).forAll {
            shouldThrowExactly<IllegalArgumentException> {
                LottoScore(listOf(LottoRank.MISS), it)
            }
        }
    }

    "1등 2번, 3등 1번의 로또 등수 개수 조회" {
        listOf(
            LottoRank.FIRST to 2,
            LottoRank.SECOND to 0,
            LottoRank.THIRD to 1,
            LottoRank.FOURTH to 0,
        ).forAll {
            // given
            val lottoScore = LottoScore(listOf(LottoRank.FIRST, LottoRank.FIRST, LottoRank.THIRD), 2000)
            // when & then
            (lottoScore countBy it.first) shouldBe it.second
        }
    }

    "수익률 조회" {
        listOf(
            Tuple3(listOf(LottoRank.FIRST, LottoRank.SECOND), 2_000L, BigDecimal.valueOf(1_015_000)),
            Tuple3(listOf(LottoRank.FOURTH, LottoRank.FIFTH), 500_000L, BigDecimal.valueOf(0.11)),
            Tuple3(listOf(LottoRank.MISS), 10_000L, BigDecimal.valueOf(0)),
            Tuple3(listOf(LottoRank.FIFTH), 14_000L, BigDecimal.valueOf(0.36)),
        ).forAll {
            // given
            val lottoScore = LottoScore(it.a, it.b)
            // when & then
            lottoScore.ratio shouldBeEqualComparingTo it.c
        }
    }
})
