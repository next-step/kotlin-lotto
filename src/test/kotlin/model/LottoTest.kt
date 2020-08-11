package model

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    @DisplayName("같은 숫자가 로또에 있으면 exception 을 반환한다")
    fun `InvalidLotto`() {
        assertThrows<IllegalArgumentException> {
            val list: Set<LottoNumber> = setOf(1, 1, 2, 3, 4, 5).map { LottoNumber.from(it) }.toSet()
            Lotto(list)
        }
    }
}
