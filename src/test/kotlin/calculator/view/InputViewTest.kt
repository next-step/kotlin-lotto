package calculator.view

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class InputViewTest : FreeSpec({

    "toNullOrBlank" - {

        "null일 경우 0을 반환한다." {
            val inputView = InputView()

            inputView.toNullOrBlank(null) shouldBe "0"
        }

        "빈값일 경우 0을 반환한다." {
            val inputView = InputView()

            inputView.toNullOrBlank(" ") shouldBe "0"
        }
    }
})
