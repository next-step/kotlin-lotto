package lotto.service

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LottoShopTest : FunSpec({
    context("구입금액 만큼 로또를 구매한다.") {
        withData(
            1000L to 1,
            2000L to 2,
            14000L to 14,
        ) { (purchaseMoney, expectedCount) ->
            val lottos = LottoShop.purchase(purchaseMoney)
            lottos.size shouldBe expectedCount
        }
    }

    context("로또번호는 자동으로 생성된다. 숫자는 6개 이고 각 숫자의 범위는 1~45이다.") {
        val lotto = LottoGenerator.generate()
        lotto.numbers.size shouldBe 6
        lotto.numbers.numbers.forEach {
            it shouldBeInRange 1..45
        }
    }

    context("생성된 로또 번호는 중복되지 않는다.") {
        val lotto = LottoGenerator.generate()
        lotto.numbers.numbers.toSet().size shouldBe 6
    }

    context("생성된 로또 번호는 오름차순으로 정렬된다.") {
        val lotto = LottoGenerator.generate()
        lotto.numbers.numbers shouldBe lotto.numbers.numbers.sorted()
    }
})
