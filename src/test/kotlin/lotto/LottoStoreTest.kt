package lotto

import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class LottoStoreTest {
    @Test
    fun `구매 개수 만큼 로또를 생성합니다`() {
        val purchaseCount = 3
        val lottoStore = SixFortyFiveLottoStore()

        val lottoList = lottoStore.purchase(purchaseCount)

        lottoList.forEach { lotto -> lotto.shouldBeInstanceOf<SixFortyFiveLotto>() }
    }
}
