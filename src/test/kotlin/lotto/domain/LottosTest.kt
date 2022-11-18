package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottosTest: StringSpec() {
    init {
        "돈에 맞는 개수의 로또를 구입한다" {
            val money = Money(5500)
            val lottos = Lottos(money)

            lottos.buyCount shouldBe 5500 / Lotto.PRICE.value
        }
    }
}
