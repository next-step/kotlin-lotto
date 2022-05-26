package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `Lottos는 발급받은 로또 번호들을 보관한다`() {
        val lottoList = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(11, 12, 13, 14, 15, 16)),
            Lotto(listOf(12, 22, 32, 24, 25, 26))
        )

        val lottos = Lottos(lottoList)

        assertThat(lottos.value).isEqualTo(lottoList)
    }
}
