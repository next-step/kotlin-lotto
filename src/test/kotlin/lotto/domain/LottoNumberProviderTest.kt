package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoNumberProviderTest {

    @Test
    fun `lottoTryCount 만큼 Lotto 가 만들어진다`() {
        val lottoNumberProvider = LottoNumberProvider()
        val lottoList = lottoNumberProvider.getLotto(LOTTO_TRY_COUNT)
        assertEquals(4, lottoList.size)
    }

    companion object {
        private const val LOTTO_TRY_COUNT = 4
    }
}
