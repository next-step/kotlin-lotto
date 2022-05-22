package lotto

import io.kotest.core.spec.style.StringSpec

internal class MoneyTest : StringSpec({

    "금액을 통해 인스턴스를 생성한다" {
        val money = 1000

        Money.of(money)
    }
})
