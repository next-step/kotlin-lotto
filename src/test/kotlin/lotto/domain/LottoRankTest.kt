package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoRankTest : DescribeSpec({

    describe("of") {
        context("일치하는 로또 번호의 수와 보너스볼 일치 여부가 주어졌을 때") {
            it("각 해당하는 등수를 생성한다") {
                listOf(
                    LottoRank.of(6, true) to LottoRank.FIRST,
                    LottoRank.of(6, false) to LottoRank.FIRST,
                    LottoRank.of(5, true) to LottoRank.SECOND,
                    LottoRank.of(5, false) to LottoRank.THIRD,
                    LottoRank.of(4, true) to LottoRank.FOURTH,
                    LottoRank.of(4, false) to LottoRank.FOURTH,
                    LottoRank.of(3, true) to LottoRank.FIFTH,
                    LottoRank.of(3, false) to LottoRank.FIFTH,
                    LottoRank.of(2, true) to LottoRank.NOTHING,
                    LottoRank.of(2, false) to LottoRank.NOTHING,
                    LottoRank.of(1, true) to LottoRank.NOTHING,
                    LottoRank.of(1, false) to LottoRank.NOTHING,
                    LottoRank.of(0, true) to LottoRank.NOTHING,
                    LottoRank.of(0, false) to LottoRank.NOTHING,
                ).forAll { (rank, expectedRank) ->
                    rank shouldBe expectedRank
                }
            }
        }

        it("일치하는 로또 번호의 수가 0~6 사이가 아니면 IllegalArgumentException 이 발생한다") {
            listOf(-1, 7).forAll {
                shouldThrow<IllegalArgumentException> { LottoRank.of(it, false) }
            }
        }
    }
})
