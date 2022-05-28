package lotto.process

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class WinningNumberTest {
    @Test
    internal fun `지난주 당첨 번호 숫자 6개를 입력받아 LottoTicket으로 변환한다`() {
        val winningNumber = "1, 2, 3, 4, 5, 6"
        assertDoesNotThrow { WinningNumber().winningNumberToLottoTicket(winningNumber) }
    }

    @ParameterizedTest(name = "`{0}`인 경우 IllegalArgumentException 에러 발생")
    @NullAndEmptySource
    @ValueSource(strings = ["a", "1,3,4", "1,2,3,4,5,46"])
    internal fun `잘못된 당첨 번호 숫자를 입력하면 IllegalArgumentException이 발생한다`(winningNumber: String?) {
        assertThrows<IllegalArgumentException> { WinningNumber().winningNumberToLottoTicket(winningNumber) }
    }
}
