package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTest {

    private lateinit var lotto: Lotto

    @BeforeEach
    fun setUp() {
        val lottoList = listOf(1, 2, 3, 4, 5, 6)
        lotto = Lotto(lottoList)
    }

    @Test
    fun `로또 번호가 일치하는 횟수를 반환한다`() {
        val jackpotNumberList = listOf(1, 2, 3, 4, 5, 6)
        val matchLottoCount = lotto.getMatchLottoCount(jackpotNumberList)
        assertEquals(6, matchLottoCount)
    }
}
