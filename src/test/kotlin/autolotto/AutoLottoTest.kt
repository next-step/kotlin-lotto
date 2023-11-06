package autolotto

import autolotto.vo.AutoLotto
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class AutoLottoTest {
    @Test
    fun `로또 구입금액을 입력받으면 로또 수량이 결정된다`() {
        // Given
        val input = 1000L

        // When
        val lotto = AutoLotto(input)

        // Then
        lotto.count shouldBe 1L
    }

    @Test
    fun `로또 구입금액 1500원을 입력받으면 로또 수량은 1개로 결정된다`() {
        // Given
        val input = 1500L

        // When
        val lotto = AutoLotto(input)

        // Then
        lotto.count shouldBe 1L
    }

    @Test
    fun `구매수량만큼 로또를 발급한다`() {
        // Given
        val input = 10000L

        // When
        val lotto = AutoLotto(input)

        // Then
        lotto.count shouldBe 10L
        lotto.lottos.size shouldBe 10
    }
}
