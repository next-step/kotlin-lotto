package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import org.junit.jupiter.api.Test

class WinningLottoTest {
    @Test
    fun `로또 번호와 보너스 번호를 받아 당첨 로또를 생성한다`() {
        shouldNotThrowAny { WinningLotto.from(listOf(1, 2, 3, 4, 5, 6), 7) }
    }
}
