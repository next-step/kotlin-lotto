package lotto.controller

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class EndLottoRequestSpec : FunSpec({
    test("우승자 번호와 보너스볼 입력값으로 로또 종료 요청이 생성된다") {
        val winningNumbersInput = "1, 2, 3"
        val bonusNumberInput = "5"

        val result = EndLottoRequest.from(winningNumbersInput, bonusNumberInput)

        result.winningNumbers shouldBe listOf(1, 2, 3)
        result.bonusNumber shouldBe 5
    }

    test("우승자 번호를 ', '를 구분자로 구분했을 때 숫자가 아닌 입력값이라면 요청 생성에 실패한다") {
        val winningNumbersInput = "1,2, 3"
        val bonusNumberInput = "5"

        shouldThrow<IllegalArgumentException> {
            EndLottoRequest.from(winningNumbersInput, bonusNumberInput)
        }
    }

    test("보너스볼 입력 값이 숫자가 아닌 입력 값이라면 요청 생성에 실패한다") {
        val winningNumbersInput = "1, 2, 3"
        val bonusNumberInput = "5!"

        shouldThrow<IllegalArgumentException> {
            EndLottoRequest.from(winningNumbersInput, bonusNumberInput)
        }
    }
})
