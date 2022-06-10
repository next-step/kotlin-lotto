package lotto.ui

import org.junit.jupiter.api.Test

internal class ResultViewTest {

    @Test
    fun showLottoTickets() {
    }

    @Test
    fun showMatchResult() {
        // given
        val money = 14000
        val result = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3)
        // val expectedMessage = "3 개 일치(5000 원) - 1 개"

        // when
        val resultMessage = ResultView().showMatchResult(money, result)

        // then
        // Assertions.assertThat(resultMessage).contains(expectedMessage)
    }
}
