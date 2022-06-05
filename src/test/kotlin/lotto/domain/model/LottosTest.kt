package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `Lottos는 발급받은 로또 번호들을 보관한다`() {
        val lottoList = listOf(
            Lotto.from(1, 2, 3, 4, 5, 6),
            Lotto.from(11, 12, 13, 14, 15, 16),
            Lotto.from(12, 22, 32, 24, 25, 26)
        )

        val lottos = Lottos(lottoList)

        assertThat(lottos.value).isEqualTo(lottoList)
    }

    @Test
    fun `발급할 로또 개수와 LottoFactory를 받아 Lottos를 만들 수 있다`() {
        val lottos = Lottos.of(
            2,
            object : LottoFactory {
                override fun create(): Lotto {
                    return Lotto.from(1, 2, 3, 4, 5, 6)
                }
            }
        )

        assertThat(lottos.value.size).isEqualTo(2)
    }
}
