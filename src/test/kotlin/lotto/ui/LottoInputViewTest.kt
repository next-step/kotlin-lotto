package lotto.ui

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoInputViewTest {

    @ParameterizedTest
    @CsvSource(
        "14000, 14",
        "15300, 15",
        "600, 0",
    )
    fun `Return number of lottery tickets that can be purchased`(input: String, expected: Int) {
        // when
        System.setIn(input.byteInputStream())
        val (_, lotteryTickets) = LottoInputView.getPurchaseAmount()

        // then
        assertThat(lotteryTickets).isEqualTo(expected)
    }
}
