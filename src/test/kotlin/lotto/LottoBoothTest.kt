package lotto

import lotto.domain.LottoBooth
import lotto.domain.LottoBuyStrategy
import lotto.domain.LottoNumbers
import lotto.domain.ManualLottoCreator
import lotto.domain.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoBoothTest {
    @Test
    fun `로또 부스는 로또 구매 전략에 맞는 로또 개수를 제시한다`() {
        val strategy = LottoBuyStrategy(
            Money(10000),
            ManualLottoCreator.createLottoList(LottoNumbers(1, 2, 3, 4, 5, 6))
        )
        assertThat(LottoBooth.publishLottos(strategy).lottoList.size).isEqualTo(10)
    }
}
