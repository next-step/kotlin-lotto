package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPurchaseInfoTest {
    @Test
    fun successCase() {
        val lottoPurchaseInfo = LottoPurchaseInfo(14123, listOf(Lotto.fromNumbers(1, 2, 3, 4, 5, 6)))

        assertThat(lottoPurchaseInfo.calculatePurchaseLottoCount()).isEqualTo(14)
        assertThat(lottoPurchaseInfo.calculateChange()).isEqualTo(123)
        assertThat(lottoPurchaseInfo.calculatePurchaseAmount()).isEqualTo(14000)
        assertThat(lottoPurchaseInfo.calculateAutoLottoCount()).isEqualTo(13)
    }

    @Test
    fun failureAmountCase() {
        try {
            LottoPurchaseInfo(0, listOf(Lotto.fromNumbers(1, 2, 3, 4, 5, 6)))
        } catch (e: IllegalArgumentException) {
            assertThat(e.message).isEqualTo("구매 금액은 0원보다 커야 합니다. 입력한 구매금액: 0")
        }
    }

    @Test
    fun failureManualLottoCountCase() {
        try {
            LottoPurchaseInfo(10000, emptyList())
        } catch (e: IllegalArgumentException) {
            assertThat(e.message).isEqualTo("로또 수는 1 이상이어야 합니다. 입력한 로또 수: 0")
        }
    }
}
