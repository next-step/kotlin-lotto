package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPurchaseHandlerTest {

    @Test
    fun `0원이 입력된 경우 로또를 한장도 발급하지 않는다`() {
        val priceInfo = LottoPurchaseHandler.calculateLottoCountByAmount(0)
        assertThat(priceInfo.count).isEqualTo(0)
    }

    @Test
    fun `금액에 맞는 로또의 수를 발급하고 잔돈을 계산한다`() {
        val priceInfo = LottoPurchaseHandler.calculateLottoCountByAmount(15500)
        assertThat(priceInfo.count).isEqualTo(15)
        assertThat(priceInfo.change).isEqualTo(500)
    }
}
