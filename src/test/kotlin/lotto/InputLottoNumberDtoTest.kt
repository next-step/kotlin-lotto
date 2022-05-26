package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.dto.InputLottoNumberDto
import lotto.dto.InputLottoNumberDto.Companion.CANNOT_CONVERT_INT
import lotto.dto.InputLottoNumberDto.Companion.NEGATIVE_ERROR

class InputLottoNumberDtoTest : FreeSpec({

    "of" - {

        "입력 값이 정수로 변환되어야한다." {
            val inputLotto = listOf("1", "2", "3", "4", "5", "6")
            val bonusBall = "1"
            InputLottoNumberDto.of(inputLotto, bonusBall)
                .lasWeekWinningNumber shouldBe listOf(1, 2, 3, 4, 5, 6)
        }

        "정수로 변환되지 못한 경우 IllegalArgumentException" {
            val inputLotto = listOf("1", "2", "test", "4", "5", "6")
            val bonusBall = "1"
            val exception = shouldThrow<IllegalArgumentException> {
                InputLottoNumberDto.of(inputLotto, bonusBall)
            }
            exception.message shouldBe CANNOT_CONVERT_INT
        }

        "음수가 들어올 경우 IllegalArgumentException" {
            val inputLotto = listOf("1", "2", "-1", "4", "5", "6")
            val bonusBall = "1"
            val exception = shouldThrow<IllegalArgumentException> {
                InputLottoNumberDto.of(inputLotto, bonusBall)
            }
            exception.message shouldBe NEGATIVE_ERROR
        }
    }
})
