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
    @DisplayName("지난주 당첨 번호를 입력한다")
    fun `inputPrizeList`() {
        lottoManager.buy(1_000)
        lottoManager.setPrize(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lottoManager.prizeStatList).isNotNull
    }
}
