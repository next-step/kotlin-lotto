package lotto.application.vo

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.StringSpec

class PurchaseCountsTest : StringSpec({
    "자동, 수동 로또 개수를 가지는 객체를 생성할수 있다" {
        shouldNotThrow<Throwable> {
            PurchaseCounts(autoLottoCount = PurchaseCount(1), manualLottoCount = PurchaseCount(2))
        }
    }
})
