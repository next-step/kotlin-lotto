package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoPurchaseInfoTest {

    @Test
    fun `정상 케이스`() {
        val lottoPurchaseInfo = LottoPurchaseInfo(money = 5_000, manualLottoCount = 2)
        assertThat(lottoPurchaseInfo.manualLottoCount).isEqualTo(2)
        assertThat(lottoPurchaseInfo.autoLottoCount).isEqualTo(3)
    }

    @Test
    fun `로또 구매 금액이 1000원 미만이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException>(
            message = "로또 구매 금액은 1000원 이상이어야 합니다. 입력된 금액 = 999",
        ) {
            LottoPurchaseInfo(money = 999, manualLottoCount = 0)
        }
    }

    @Test
    fun `수동 로또 개수가 음수이면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException>(
            message = "수동 로또 개수는 음수가 될 수 없습니다. 입력된 수동 로또 개수 = -1",
        ) {
            LottoPurchaseInfo(money = 1000, manualLottoCount = -1)
        }
    }

    @Test
    fun `수동 로또 개수가 구매 금액을 초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException>(
            message = "수동 로또 개수는 구매 금액을 초과할 수 없습니다. 입력된 수동 로또 개수 = 2, 입력된 구매 금액 = 1000",
        ) {
            LottoPurchaseInfo(money = 1000, manualLottoCount = 2)
        }
    }
}
