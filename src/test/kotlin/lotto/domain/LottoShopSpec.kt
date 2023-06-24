package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.domain.extension.lottoNumbers

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
            val generatedLottosResponse = LottoShop.sellByMoneyWithManualLottos(money)

            generatedLottosResponse.lottos.lottoQuantity.value shouldBe numberOfLottos
        }

        context("로또 비용(5000원)과 수동 로또 번호(3개)가 주어지면") {
            val money = Money(5000)
            val manualLottoNumbers = listOf(
                lottoNumbers(1, 2, 3, 4, 5, 6),
                lottoNumbers(1, 2, 3, 4, 5, 7),
                lottoNumbers(1, 2, 3, 4, 5, 8),
            )

            val generatedLottosResponse = LottoShop.sellByMoneyWithManualLottos(money, manualLottoNumbers)

            it("수동 로또(3개)를 반환한다.") {
                generatedLottosResponse.manualLottos.lottoQuantity.value shouldBe 3
                generatedLottosResponse.manualLottos.values.shouldForAll { lotto ->
                    manualLottoNumbers.shouldContainAll(lotto.numbers)
                }
            }
            it("수동 로또 구매 금액을 제외한 나머지 금액으로 자동 로또(2개)를 반환한다.") {
                generatedLottosResponse.autoLottos.lottoQuantity.value shouldBe 2
            }
        }

        context("로또 비용(1000원)보다 구매하려는 수동 로또 번호(2개)가 더 많으면") {
            val money = Money(1000)
            val manualLottoNumbers = listOf(
                lottoNumbers(1, 2, 3, 4, 5, 6),
                lottoNumbers(1, 2, 3, 4, 5, 7),
            )

            it("예외가 발생한다. (로또를 구매할 수 없다.)") {
                shouldThrowExactly<IllegalArgumentException> {
                    LottoShop.sellByMoneyWithManualLottos(money, manualLottoNumbers)
                }
            }
        }

        context("로또 비용이 1000원 미만이면") {
            val money = Money(500)

            it("로또를 구매할 수 없다.") {
                val generatedLottosResponse = LottoShop.sellByMoneyWithManualLottos(money)

                generatedLottosResponse.lottos.lottoQuantity.value shouldBe 0
            }
        }
    }
})
