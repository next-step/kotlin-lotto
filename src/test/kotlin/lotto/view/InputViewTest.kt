package lotto.view

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

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
}
