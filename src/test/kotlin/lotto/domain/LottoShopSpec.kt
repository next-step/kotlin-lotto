package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

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
            val lottos = LottoShop.sellByMoney(money)

            lottos.size shouldBe numberOfLottos
        }
    }
})
