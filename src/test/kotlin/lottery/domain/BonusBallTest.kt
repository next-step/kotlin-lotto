package lottery.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusBallTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `보너스 볼은 당첨 번호와 중복되서는 안된다`(bonusBall: Int) {
        assertThrows<IllegalArgumentException> {
            BonusBall(bonusBall, WinnerLottery(listOf(1, 2, 3, 4, 5, 6)))
        }
    }
}
