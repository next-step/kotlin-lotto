package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoPurchaseHandlerTest {

    @Test
    fun `0원이 입력된 경우 에러를 출력한다`() {
        assertThrows<IllegalArgumentException> {
            LottoPurchaseHandler.calculateLottoCountByAmount(0, 0)
        }
    }

    @Test
    fun `금액에 맞는 로또의 수를 발급하고 잔돈을 계산한다`() {
        val priceInfo = LottoPurchaseHandler.calculateLottoCountByAmount(15500, 0)
        assertThat(priceInfo.count).isEqualTo(15)
        assertThat(priceInfo.change).isEqualTo(500)
    }
}
