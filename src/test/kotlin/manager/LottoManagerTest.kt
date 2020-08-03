package manager

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoManagerTest {
    private lateinit var lottoManager: LottoManager

    @BeforeEach
    fun init() {
        lottoManager = LottoManager()
    }

    @Test
    @DisplayName("구매 금액만큼 Lotto 를 생성한다")
    fun `buyAmoutOfPurchaseEqualSize`() {
        lottoManager.buy(LottoManager.LOTTO_PRICE)
        assertThat(lottoManager.lottoCount).isEqualTo(1)
    }

    @Test
    @DisplayName("당첨 번호가 저장된다")
    fun `prize`() {
        val lottoPrize = listOf(1, 2, 3, 4, 5, 6)
        lottoManager.prize = listOf(1, 2, 3, 4, 5, 6)
        assertThat(lottoManager.prize).isEqualTo(lottoPrize)
    }

    @Test
    @DisplayName("당첨 통계 목록이 반환된다")
    fun `prizeStatList`() {
        lottoManager.prize = listOf(1, 2, 3, 4, 5, 6)
        lottoManager.buy(LottoManager.LOTTO_PRICE * 10)
        assertThat(lottoManager.prizeStatList).isNotNull
    }

    @Test
    @DisplayName("수익률이 반환된다")
    fun `earningRate`() {
        lottoManager.prize = listOf(1, 2, 3, 4, 5, 6)
        lottoManager.buy(LottoManager.LOTTO_PRICE * 10)
        println(lottoManager.earningRate)
        assertThat(lottoManager.earningRate).isPositive()
    }
}
