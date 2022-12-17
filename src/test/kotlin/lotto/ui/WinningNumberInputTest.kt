package lotto.ui

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class WinningNumberInputTest : FunSpec({
    context("입력한 당첨 번호 조회") {
        test("입력한 문자열 당첨 번호를 숫자 리스트로 조회할 수 있다.") {
            val winningNumberInput = WinningNumberInput(value = "1, 2, 3, 4, 5, 6")
            val actual = winningNumberInput.getNumbers()
            actual shouldContainExactly listOf(1, 2, 3, 4, 5, 6)
        }
    }
})
