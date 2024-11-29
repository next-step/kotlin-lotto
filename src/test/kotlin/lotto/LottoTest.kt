package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun `로또 번호는 6개여야 한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호는 중복될 수 없다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `로또 번호는 1부터 45 사이여야 한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `당첨 번호와 일치하는 개수를 반환한다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        assertEquals(3, lotto.match(winningLotto))
    }
}
