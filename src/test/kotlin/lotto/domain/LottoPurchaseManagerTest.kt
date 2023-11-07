package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoPurchaseManagerTest {

    private val lottoPurchaseManager = LottoPurchaseManager()

    @Test
    fun `입력한 금액에 따라 로또 개수가 출력 된다`() {
        val lottoCount = lottoPurchaseManager.getLottoCount(MONEY)
        assertEquals(LOTTO_COUNT, lottoCount)
    }

    @Test
    fun `로또는 최소 1개는 사야 한다`() {
        assertThrows<IllegalArgumentException> {
            lottoPurchaseManager.getLottoCount(100)
        }
    }

    companion object {
        private const val MONEY = 14000
        private const val LOTTO_COUNT = 14
    }
}
