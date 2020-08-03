package lotto

import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `수익률 확인`() {
        val lotto = LottoGame(4)
        val prizeNumbers = listOf(1, 2, 3, 4, 5, 6)
        lotto.checkPrize(prizeNumbers)
    }
}
