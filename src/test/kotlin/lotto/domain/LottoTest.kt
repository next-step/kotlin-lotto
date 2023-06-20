package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LottoTest {
    @Test
    internal fun `로또의 숫자는 6개이며 모든 숫자는 1과45의 사이이다`() {
        val lotto = Lotto(ShuffleNumGenerator())
        lotto.numbers.size shouldBe 6
        lotto.numbers.all { it in 1..45 } shouldBe true
    }
}
