package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.dto.InputLottoMachineRequestDto
import lotto.dto.InputLottoMachineRequestDto.Companion.CANNOT_CONVERT_INT

class InputLottoMachineRequestDtoTest : FreeSpec({

    "of" - {

        "입력값이 정수로 변환되어야한다." {
            val inputPayment = "1000"
            val inputManualLottoCount = "2"

            val lottoMachineRequest = InputLottoMachineRequestDto.of(inputPayment, inputManualLottoCount)
            lottoMachineRequest.payment shouldBe 1000
            lottoMachineRequest.manualLottoCount shouldBe 2
        }

        "정수로 변환되지 못한 경우 IllegalArgumentException" {
            val inputPayment = "test"
            val inputManualLottoCount = "2"

            val exception = shouldThrow<IllegalArgumentException> {
                InputLottoMachineRequestDto.of(inputPayment, inputManualLottoCount)
            }
            exception.message shouldBe CANNOT_CONVERT_INT
        }

        "음수인 경우 IllegalArgumentException" {
            val inputPayment = "test"
            val inputManualLottoCount = "-2"

            val exception = shouldThrow<IllegalArgumentException> {
                InputLottoMachineRequestDto.of(inputPayment, inputManualLottoCount)
            }
            exception.message shouldBe CANNOT_CONVERT_INT
        }
    }
})
