package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoWinningTestLevel {

    private val lottoWinning = LottoWinning()

    @Test
    fun `입력된 로또 번호를 구분자를 이용해 List 로 만들어 준다`() {
        val jackpotList = lottoWinning.splitLottoNumber(JACKPOT_NUMBERS).lotto
        val expectedList = LOTTO

        assertEquals(expectedList, jackpotList)
    }

    @Test
    fun `lottoList 에서 jackpotNumbers 와 매칭 되는 개수에 해당하는 JackpotLevel 의 value 가 반환 된다`() {
        val jackpotNumbers = Lotto(LOTTO)
        val lottoList: List<Lotto> = listOf(jackpotNumbers)

        val findJackpotLotto = lottoWinning.checkLottoWinning(jackpotNumbers, lottoList)
        assertEquals(findJackpotLotto, listOf(JackpotLevel.SIX_MATCH))
    }

    companion object {
        private const val JACKPOT_NUMBERS = "1, 2, 3, 4, 5, 6"
        private val LOTTO = listOf(1, 2, 3, 4, 5, 6)
    }
}
