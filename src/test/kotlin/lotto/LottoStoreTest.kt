package lotto

import io.kotest.matchers.shouldBe
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

    @Test
    fun `로또의 당첨 여부를 계산합니다`() {
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val numbers = listOf(1, 2, 3, 7, 8, 9)

        val result = SixFortyFiveLotto(numbers).checkWinning(winningNumber)

        result shouldBe 3
    }
}
