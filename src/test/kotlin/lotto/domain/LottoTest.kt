package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `로또 한장은 6개의 숫자로 이루어져있다`() {
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        assertEquals(6, lotto.lottoNumbers.size)
    }
}
