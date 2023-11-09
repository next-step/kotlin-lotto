package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoResultTestLevel {

    private val lottoResult = LottoResult()

    @Test
    fun `입력된 로또 번호를 구분자를 이용해 List 로 만들어 준다`() {
        val jackpotList = lottoResult.splitLottoNumber(JACKPOT_NUMBERS)
        val expectedList = LOTTO

        assertEquals(expectedList, jackpotList)
    }

    @Test
    fun `lottoList 에서 jackpotNumbers 와 매칭 되는 개수에 해당하는 JackpotLevel 의 value 가 반환 된다`() {
        val lotto = Lotto(LOTTO)
        val jackpotNumbers: List<Int> = LOTTO
        val lottoList: List<Lotto> = listOf(lotto)

        val findJackpotLotto = lottoResult.findJackpotLotto(jackpotNumbers, lottoList)
        assertEquals(findJackpotLotto, listOf(JackpotLevel.SIX_MATCH))
    }

    companion object {
        private const val JACKPOT_NUMBERS = "1, 2, 3, 4, 5, 6"
        private val LOTTO = listOf(1, 2, 3, 4, 5, 6)
    }
}
