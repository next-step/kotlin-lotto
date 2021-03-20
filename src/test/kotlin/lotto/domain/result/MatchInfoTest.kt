package lotto.domain.result

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MatchInfoTest {
    @DisplayName("매치 수가 로또 수 보다 클 경우 예외 발생")
    @Test
    fun init() {
        assertThrows<IllegalArgumentException> { MatchInfo.of(7, true) }
    }
}
