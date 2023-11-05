package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoBoothTest {
    @Test
    fun `로또 부스는 가격 입력 시 가격에 맞는 로또를 제시한다`() {
        assertThat(LottoBooth.publishLottos(Money(10000)).size).isEqualTo(10)
        assertThat(LottoBooth.publishLottos(Money(3500)).size).isEqualTo(3)
    }
}
