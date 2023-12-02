package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {
    @Test
    fun `보너스 번호는 다른 로또 번호와 중복될 수 없다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto.of(numbers)

        assertThrows<IllegalArgumentException> {
            WinningLotto(lotto, LottoNumber(1))
        }
    }
}
