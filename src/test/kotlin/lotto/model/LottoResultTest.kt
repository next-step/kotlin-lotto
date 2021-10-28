package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoResultTest {

    @DisplayName("같은 번호가 5개 일치하면 2등이 된다.")
    @Test
    fun lottoResultWinners() {
        val lotto = Lotto(
            price = 1000,
            numbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        )
        val winLottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 10)
        val result = LottoResult(listOf(lotto), winLottoNumbers)

        val expected = 1
        val actual = result.winners(LottoRank.Second)

        assertEquals(expected, actual)
    }
}
