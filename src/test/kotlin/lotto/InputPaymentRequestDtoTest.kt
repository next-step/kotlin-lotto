package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.dto.InputPaymentRequestDto
import lotto.dto.InputPaymentRequestDto.Companion.CANNOT_CONVERT_INT

class InputPaymentRequestDtoTest : FreeSpec({

    "convertPayment" - {

        "입력값이 정수로 변환되어야한다." {
            val input = "1000"
            InputPaymentRequestDto.convertPayment(input).payment shouldBe 1000
        }

        "정수로 변환되지 못한 경우 IllegalArgumentException" {
            val input = "test"
            val exception = shouldThrow<IllegalArgumentException> {
                InputPaymentRequestDto.convertPayment(input)
            }
            exception.message shouldBe CANNOT_CONVERT_INT
        }
    }
})
