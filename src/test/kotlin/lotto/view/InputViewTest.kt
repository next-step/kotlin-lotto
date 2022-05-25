package lotto.view

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.05.24..
 */
class InputViewTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `구매금액에 빈칸이나 Null이 들어가면 IllegalArgumentException을 던진다`(source: String?) {
        assertThrows<IllegalArgumentException> {
            InputView.getPrice { source }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["five-dollar", "오천원"])
    fun `구매금액이 숫자가 아니라면 IllegalArgumentException을 던진다`(source: String?) {
        assertThrows<IllegalArgumentException> {
            InputView.getPrice { source }
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `지난 주 당첨 번호에 빈칸이나 Null이 들어가면 IllegalArgumentException을 던진다`(source: String?) {
        assertThrows<IllegalArgumentException> {
            InputView.getWinningNumber { source }
        }
    }
}
