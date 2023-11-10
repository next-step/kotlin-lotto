package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import lotto.ui.InputView

class InputTest : StringSpec({
    "금액을 입력 하면 갯수가 잘 나온다" {
        val input = 14000
        InputView.transformLottoCountFromInput(input)
    }

    "당첨 번호에 숫자가 아닌 값을 입력하면 에러가 발생한다" {
        val input = "1,2,3,4,5,a"
        shouldThrow<IllegalStateException> {
            InputView.transformLastWeekLottoListFromInput(input)
        }
    }
})
