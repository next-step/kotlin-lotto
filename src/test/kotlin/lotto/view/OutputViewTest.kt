package lotto.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OutputViewTest : StringSpec({

    "0일때는 손해로 출력 되어야 한다" {
        val actual = (0.00).toDouble().incomeStatement()
        actual shouldBe "손해"
    }

    "1일 미만인 경우 손해로 출력 되어야 한다" {
        val actual = (0.99).incomeStatement()
        actual shouldBe "손해"
    }

    "1 일때는 이익으로 출력 되어야 한다" {
        val actual = (1.00).toDouble().incomeStatement()
        actual shouldBe "이익"
    }
})
