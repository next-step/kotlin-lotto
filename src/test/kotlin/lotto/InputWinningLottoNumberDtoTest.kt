package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.InputWinningLottoNumberDto.Companion.CANNOT_CONVERT_INT
import lotto.InputWinningLottoNumberDto.Companion.NEGATIVE_ERROR

class InputWinningLottoNumberDtoTest : FreeSpec({

    "convertInt" - {

        "입력 리스트가 정수로 변환되어야한다." {
            val input = listOf("1", "2", "3", "4", "5", "6")
            InputWinningLottoNumberDto.convertInt(input)
                .lasWeekWinningNumber shouldBe listOf(1, 2, 3, 4, 5, 6)
        }

        "정수로 변환되지 못한 경우 IllegalArgumentException" {
            val input = listOf("1", "2", "test", "4", "5", "6")
            val exception = shouldThrow<IllegalArgumentException> {
                InputWinningLottoNumberDto.convertInt(input)
            }
            exception.message shouldBe CANNOT_CONVERT_INT
        }

        "음수가 들어올 경우 IllegalArgumentException" {
            val input = listOf("1", "2", "-1", "4", "5", "6")
            val exception = shouldThrow<IllegalArgumentException> {
                InputWinningLottoNumberDto.convertInt(input)
            }
            exception.message shouldBe NEGATIVE_ERROR
        }
    }
})
