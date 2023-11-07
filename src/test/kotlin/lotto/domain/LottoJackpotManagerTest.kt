package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoJackpotManagerTest {

    private val lottoJackpotManager = LottoJackpotManager()

    @Test
    fun `입력된 로또 번호를 구분자를 이용해 List 로 만들어 준다`() {
        val jackpotList = lottoJackpotManager.splitLottoNumber(JACKPOT_NUMBERS)
        val expectedList = listOf(1, 2, 3, 4, 5, 6)

        assertEquals(expectedList, jackpotList)
    }

    companion object {
        private const val JACKPOT_NUMBERS = "1, 2, 3, 4, 5, 6"
    }
}
