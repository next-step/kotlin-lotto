package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoPurchaseManagerTest {

    @Test
    fun `입력한 금액에 따라 로또 개수가 출력 된다`() {

        val lottoPurchaseManager = LottoPurchaseManager()
        val lottoCount = lottoPurchaseManager.getLottoCount(14000)
        assertEquals(14, lottoCount)
    }
}
