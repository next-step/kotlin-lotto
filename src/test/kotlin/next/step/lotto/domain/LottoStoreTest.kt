package next.step.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoStoreTest : DescribeSpec({

    describe("LottoStore method") {
        val lottoStore = LottoStore.of(LottoNumberRandomGenerator)
        context("일정 금액으로 구매하면, 지불한 금액만큼 로또 제공") {
            data class BuyLottos(val payment: Int, val expected: Int)
            withData(
                BuyLottos(1000, 1),
                BuyLottos(14000, 14),
                BuyLottos(2500, 2)
            ) { (payment, expected) ->
                lottoStore.buy(payment).size() shouldBe expected
            }
        }

        context("돈이 충분할 때, 수동으로 입력한 로또와 금액으로 구매하면") {
            it("남은 금액을 제공") {
                lottoStore.buy(
                    1500,
                    Lottos.of(setOf(Lotto.from(setOf(1, 2, 3, 4, 5, 6))))
                ) shouldBe 500
            }
        }

        context("돈이 충분하지 않을 때, 수동으로 입력한 로또와 금액으로 구매하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    lottoStore.buy(
                        500,
                        Lottos.of(setOf(Lotto.from(setOf(1, 2, 3, 4, 5, 6))))
                    )
                }.message shouldBe "500원으로는 로또를 1개 살 수 없습니다."
            }
        }


    }
})
