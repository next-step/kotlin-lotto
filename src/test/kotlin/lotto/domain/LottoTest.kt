package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    private lateinit var lotto: Lotto

    @BeforeEach
    fun setUp() {
        val lottoList = (1..6).map { LottoNumber(it) }
        lotto = Lotto(lottoList)
    }

    @Test
    fun `로또 번호가 일치하는 횟수를 반환한다`() {
        val lottoList = Lotto((1..6).map { LottoNumber(it) })
        val matchLottoCount = lotto.countMatchingNumbers(lottoList)
        assertEquals(6, matchLottoCount)
    }

    @Test
    fun `로또의 개수는 6개이어야 합니다`() {
        val lottoList = (1..5).map { LottoNumber(it) }
        assertThrows<IllegalArgumentException> {
            Lotto(lottoList)
        }
    }

    @Test
    fun `로또 번호는 중복 될 수 없다`() {
        val list = listOf(1, 2, 3, 4, 5, 5).map { LottoNumber(it) }
        assertThrows<IllegalArgumentException> {
            Lotto(list)
        }
    }
}
