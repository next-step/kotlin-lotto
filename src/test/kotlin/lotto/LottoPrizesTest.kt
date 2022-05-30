package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoPrizesTest {

    @Test
    fun `14000원으로 3개의 당첨번호가 있는 경우 수익률 계산`() {
        assertThat(LottoPrizes(listOf(LottoPrize.THIRD)).earnings(PurchaseMoney(14000))).isEqualTo(0.35)
    }
}
