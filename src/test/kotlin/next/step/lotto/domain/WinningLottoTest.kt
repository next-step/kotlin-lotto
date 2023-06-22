package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : DescribeSpec({

    describe("당첨 확인") {
        context("당첨 번호와 보너스 번호를 넣으면") {
            it("당첨된 개수와 보너스 번호 매칭 여부에 따라 LottoWinningCount 제공") {
                WinningLotto.of(setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }.toSet(), LottoNumber.of(7)).match(
                    Lottos.of(
                        setOf(
                            Lotto.from(setOf(1, 2, 3, 4, 5, 6)),
                            Lotto.from(setOf(1, 2, 3, 4, 5, 7)),
                            Lotto.from(setOf(1, 2, 3, 4, 5, 8)),
                            Lotto.from(setOf(1, 2, 3, 4, 8, 7)),
                            Lotto.from(setOf(1, 2, 3, 9, 8, 7)),
                            Lotto.from(setOf(1, 2, 10, 9, 8, 7)),
                            Lotto.from(setOf(1, 11, 10, 9, 8, 7)),
                            Lotto.from(setOf(12, 11, 10, 9, 8, 7)),
                        )
                    )
                ) shouldBe
                        LottoWinningStat.of(
                            mapOf(
                                Pair(LottoRank.FIRST, 1),
                                Pair(LottoRank.SECOND, 1),
                                Pair(LottoRank.THIRD, 1),
                                Pair(LottoRank.FOURTH, 1),
                                Pair(LottoRank.FIFTH, 1),
                                Pair(LottoRank.MISS, 3),
                            )
                        )
            }
        }
    }

})
