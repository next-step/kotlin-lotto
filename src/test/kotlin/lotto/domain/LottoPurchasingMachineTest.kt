package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoPurchasingMachineTest : StringSpec({
    "구매금액을 입력하면 몇 개를 구매했는지 반환해야 한다." {
        LottoPurchasingMachine(14000).buyCount() shouldBe 14
        LottoPurchasingMachine(25000).buyCount() shouldBe 25
    }

    "구매금액은 1000원 단위로만 가능하다." {
        val exception =
            shouldThrow<IllegalArgumentException> {
                LottoPurchasingMachine(1400)
            }
        exception.message shouldBe "구매금액은 1000원 단위로만 가능합니다."
    }
})
