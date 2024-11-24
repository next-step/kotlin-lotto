package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `Lottos는 Lotto를 가진다`() {
        val lottos =
            Lottos(
                listOf(
                    Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
                ),
            )

        assertThat(lottos.size).isEqualTo(2)
    }
}
