package next.step.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoTest : DescribeSpec({

    describe("Lotto 생성") {
        context("lotto 가격만큼 지불하면, 남은 금액을 제공") {
            data class BuyLotto(val payment: Int, val expected: Int)
            withData(
                BuyLotto(1000, 0),
                BuyLotto(1500, 500),
                BuyLotto(2500, 1500)
            ) { (payment, expected) ->
                Lotto.preview().buy(payment) shouldBe expected
            }
        }

        context("lotto 가격보다 낮게 지불하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    Lotto.preview().buy(Lotto.LOTTO_PRICE - 1)
                }
            }
        }

        context("같은 LottoNumbers로 생성하면") {
            it("동등함") {
                Lotto.of(LottoNumbers.from((1..6).toSet())) shouldBe Lotto.of(LottoNumbers.from((1..6).toSet()))
            }
        }

        context("미리보기 요청하면") {
            it("랜덤으로 생성된 로또 제공") {
                Lotto.preview().numbers() shouldHaveSize 6
            }
        }
    }

    describe("Lotto 를 살 수 있는지 판별") {
        context("lotto 가격보다 낮게 넣으면") {
            it("살 수 없다고 알려줌") {
                Lotto.canBuy(Lotto.LOTTO_PRICE - 1) shouldBe false
            }
        }

        context("lotto 가격 이상으로 넣으면") {
            it("살 수 있다고 알려줌") {
                Lotto.canBuy(Lotto.LOTTO_PRICE) shouldBe true
            }
        }
    }

    describe("당첨 확인") {
        context("당첨 번호를 넣으면") {
            it("당첨된 개수에 따라 LottoWinningCount 제공") {
                Lottos.of(
                    setOf(
                        Lotto.from(setOf(1, 2, 3, 4, 5, 6)),
                        Lotto.from(setOf(1, 2, 3, 4, 5, 7)),
                        Lotto.from(setOf(1, 2, 3, 4, 8, 7)),
                        Lotto.from(setOf(1, 2, 3, 9, 8, 7)),
                        Lotto.from(setOf(1, 2, 10, 9, 8, 7)),
                        Lotto.from(setOf(1, 11, 10, 9, 8, 7)),
                        Lotto.from(setOf(12, 11, 10, 9, 8, 7)),
                    )
                ).match(LottoWinningNumbers.from("1,2,3,4,5,6")) shouldBe
                        LottoWinningStat.of(
                            mapOf(
                                Pair(LottoWinningCount.SIX, 1),
                                Pair(LottoWinningCount.FIVE, 1),
                                Pair(LottoWinningCount.FOUR, 1),
                                Pair(LottoWinningCount.THREE, 1),
                                Pair(LottoWinningCount.NONE, 3),
                            )
                        )
            }
        }
    }
})
