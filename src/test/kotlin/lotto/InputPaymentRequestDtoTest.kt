package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.InputPaymentRequestDto.Companion.CANNOT_CONVERT_INT

class InputPaymentRequestDtoTest : FreeSpec({

    "covertInt" - {

        "입력값이 정수로 변환되어야한다." {
            val input = "1000"
            InputPaymentRequestDto.convertInt(input).payment shouldBe 1000
        }

        "정수로 변환되지 못한 경우 IllegalArgumentException" {
            val input = "test"
            val exception = shouldThrow<IllegalArgumentException> {
                InputPaymentRequestDto.convertInt(input)
            }
            exception.message shouldBe CANNOT_CONVERT_INT
        }
    }
})
