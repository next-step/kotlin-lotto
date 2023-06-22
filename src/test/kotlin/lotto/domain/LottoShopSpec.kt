package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.domain.extension.lotto
import lotto.domain.extension.lottos

class LottoShopSpec : DescribeSpec({
    describe("로또 판매") {
        withData(
            nameFn = { (money, numberOfLottos) -> "로또 비용 $money 를 지불하면 $numberOfLottos 개의 로또를 반환한다." },
            ts = listOf(
                Pair(Money(1000), 1),
                Pair(Money(3700), 3),
                Pair(Money(14000), 14),
                Pair(Money(14500), 14),
            ),
        ) { (money, numberOfLottos) ->
            val lottos = LottoShop.sellByMoneyWithManualLottos(money)

            lottos.size shouldBe numberOfLottos
        }

        context("로또 비용(5000원)과 수동 로또(3개)가 주어지면") {
            val money = Money(5000)
            val manualLottos = lottos(
                Lotto(),
                Lotto(),
                Lotto(),
            )

            val lottos = LottoShop.sellByMoneyWithManualLottos(money, manualLottos)

            it("수동 로또(3개)를 반환한다.") {
                lottos.values shouldContainAll manualLottos.values
            }
            it("수동 로또 구매 금액을 제외한 나머지 금액은 자동 로또(2개)를 반환한다.") {
                lottos.size shouldBe 5
            }
        }

        context("로또 비용(1000원)보다 수동 로또(2개)가 더 많으면") {
            val money = Money(1000)
            val manualLottos = lottos(Lotto(), Lotto())

            it("예외가 발생한다. (로또를 구매할 수 없다.)") {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoShop.sellByMoneyWithManualLottos(money, manualLottos)
                }
            }
        }

        context("로또 비용이 1000원 미만이면") {
            val money = Money(500)

            it("로또를 구매할 수 없다.") {
                val lottos = LottoShop.sellByMoneyWithManualLottos(money)

                lottos.size shouldBe 0
            }
        }
    }
})
