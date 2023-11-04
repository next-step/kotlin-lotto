package lotto_auto

import io.kotest.core.spec.style.StringSpec
import lotto_auto.ui.InputView

class LottoAutoTest : StringSpec({
    "금액을 입력 하면 갯수가 잘 나온다" {
        val input = 14000
        InputView.transformLottoCountFromInput(input)
    }
})
