package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottosTest : DescribeSpec({

    describe("Lottos 생성") {
        context("일정 금액으로 구매하면, 지불한 금액만큼 로또 제공") {
            data class BuyLottos(val payment: Int, val expected: Int)
            withData(
                BuyLottos(1000, 1),
                BuyLottos(14000, 14),
                BuyLottos(2500, 2)
            ) { (payment, expected) ->
                Lottos.buy(payment).size() shouldBe expected
            }
        }
    }

    describe("당첨 확인") {
        context("당첨 번호를 넣으면") {
            it("당첨된 개수에 따라 LottoWinningCount 제공") {
                Lottos.of(
                    setOf(
                        Lotto.from(setOf(1, 2, 3, 4, 5, 7)),
                        Lotto.from(setOf(1, 2, 3, 4, 8, 7)),
                        Lotto.from(setOf(1, 2, 3, 9, 8, 7)),
                        Lotto.from(setOf(1, 2, 10, 9, 8, 7)),
                        Lotto.from(setOf(1, 11, 10, 9, 8, 7)),
                        Lotto.from(setOf(12, 11, 10, 9, 8, 7)),
                    )
                ).match(LottoWinningNumbers.from(setOf(1, 2, 3, 4, 5, 6))) shouldBe
                        LottoWinningStat.of(
                            mapOf(
                                Pair(LottoRank.FIRST, 0),
                                Pair(LottoRank.SECOND, 1),
                                Pair(LottoRank.THIRD, 1),
                                Pair(LottoRank.FOURTH, 1),
                                Pair(LottoRank.MISS, 3),
                            )
                        )
            }
        }
    }
})
