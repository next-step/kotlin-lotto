package lotto.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class WinNumberViewTest : StringSpec({

    "처음과 마지막에 빈 라인을 출력한다" {
        val io = StubIO(listOf("1,2,3,4,5,6", "7"))
        val view = WinNumberView(io)

        view.readWinNumbers()

        io.printed.first() shouldBe ""
        io.printed.last() shouldBe ""
    }

    "입력 안내 문구를 출력한다" {
        val io = StubIO(listOf("1,2,3,4,5,6", "7"))
        val view = WinNumberView(io)

        view.readWinNumbers()

        io.printed[1] shouldBe "지난 주 당첨 번호를 입력해 주세요."
    }

    "6 개의 당첨 번호를 입력받는다" {
        val io = StubIO(listOf("1,2,3,4,5,6", "7"))
        val view = WinNumberView(io)

        val winNumbers = view.readWinNumbers()

        winNumbers.value.map { it.value } shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    "유효한 숫자가 아니거나 개수가 맞지 않으면 다시 입력받는다" {
        val io = StubIO(listOf("invalid", "1, 2 ,3,4 ,5 ,6", "7"))
        val view = WinNumberView(io)

        val winNumbers = view.readWinNumbers()

        io.printed[2] shouldBe "유효한 당첨번호를 입력해주세요."
        winNumbers.value.map { it.value } shouldBe listOf(1, 2, 3, 4, 5, 6)
    }
})
