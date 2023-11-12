package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoWinningTestLevel {

    private val lottoWinning = LottoWinning(LOTTO)

    @Test
    fun `lottoList 에서 jackpotNumbers 와 매칭 되는 개수에 해당하는 JackpotLevel 의 value 가 반환 된다`() {
        val lottoList: List<Lotto> = listOf(LOTTO)

        val findJackpotLotto = lottoWinning.checkLottoWinning(lottoList)
        assertEquals(findJackpotLotto, listOf(JackpotLevel.SIX_MATCH))
    }

    companion object {
        private val LOTTO = Lotto((1..6).map { LottoNumber(it) })
    }
}
