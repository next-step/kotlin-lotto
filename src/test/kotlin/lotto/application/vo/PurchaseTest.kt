package lotto.application.vo

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PurchaseTest : StringSpec({
    "구입 객체를 생성할 수 있다" {
        shouldNotThrow<Throwable> { Purchase(10_000, 3) }
    }

    "수동 로또 구매 갯수를 조회할 수 있다" {
        Purchase(10_000, 3).purchaseCounts.manualLottoCount shouldBe PurchaseCount(3)
    }

    "자동 로또 구매 갯수를 조회할 수 있다" {
        Purchase(10_000, 3).purchaseCounts.autoLottoCount shouldBe PurchaseCount(7)
    }
})
