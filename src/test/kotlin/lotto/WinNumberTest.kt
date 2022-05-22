package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class WinNumberTest : StringSpec({

    "숫자 목록을 받아 인스턴스를 생성한다" {
        val winNumbers = WinNumbers(listOf(1, 2, 3, 4, 5, 6))

        winNumbers.value shouldBe listOf(1, 2, 3, 4, 5, 6)
    }
})
