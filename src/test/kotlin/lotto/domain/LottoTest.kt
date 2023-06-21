package lotto.domain

import calculator.domain.Calculator
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTest {
    @Test
    internal fun `로또의 숫자는 6개이며 모든 숫자는 1과45의 사이이다`() {
        val lotto = Lotto(AutoNumGenerator())
        lotto.numbers.size shouldBe 6
        lotto.numbers.all { it in 1..45 } shouldBe true
    }

    @Test
    internal fun `로또의 숫자는 6개가 아니면 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(FiveNumGenerator())
        }
    }

    @Test
    internal fun `로또의 숫자가 1가 45의 수가 아니면 에러가  발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(BigNumGenerator())
        }
    }
}
