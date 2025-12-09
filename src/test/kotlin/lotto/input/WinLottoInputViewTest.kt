package lotto.input

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class WinLottoInputViewTest : FreeSpec({

    "당첨 번호 입력 검증" - {
        "한글 문자가 포함된 경우 예외 발생" {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLottoInputView.process("1 2 3 4 5 육") }
            exception.message shouldBe "올바른 로또번호를 입력하세요"
        }
        "범위를 벗어난 숫자가 포함된 경우 예외 발생" {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLottoInputView.process("0 2 3 4 5 46") }
            exception.message shouldBe "1부터 45까지의 숫자를 입력하세요"
        }
        "6개가 아닌 5개의 숫자를 입력한 경우 예외 발생" {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLottoInputView.process("2 4 6 8 10") }
            exception.message shouldBe "다른 숫자 6개가 아니면 안됩니다."
        }
        "중복된 숫자가 포함된 경우 예외 발생" {
            val exception =
                shouldThrow<IllegalArgumentException> { WinLottoInputView.process("2 4 6 8 10 2") }
            exception.message shouldBe "다른 숫자 6개가 아니면 안됩니다."
        }
    }
})
