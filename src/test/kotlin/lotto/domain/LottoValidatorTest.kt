package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoValidatorTest : StringSpec({
    "구매 요청 금액보다 수동의 금액이 높다면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            LottoValidator.manualLottoValidate(1000, 2)
        }.message shouldBe "1000원으로는 수동 2장을 구매할 수 없습니다."
    }

    "구매 요청 금액이 수동의 금액보다 높다면 예외가 발생하지 않는다." {
        shouldNotThrowAny {
            LottoValidator.manualLottoValidate(3000, 2)
        }
    }
})
