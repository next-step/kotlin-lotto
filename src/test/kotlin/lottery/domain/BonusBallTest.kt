package lottery.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class BonusBallTest {
    @Test
    fun `보너스 볼은 당첨 번호와 중복되서는 안된다`() {
        assertThrows<IllegalArgumentException> {
            BonusBall(1, WinnerLottery(listOf(1, 2, 3, 4, 5, 6)))
        }
    }
}
