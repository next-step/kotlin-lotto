package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

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
            PurchaseCount.from(2),
            object : LottoFactory {
                override fun create(): Lotto {
                    return Lotto.from(1, 2, 3, 4, 5, 6)
                }
            }
        )

        assertThat(lottos.value.size).isEqualTo(2)
    }

    @Test
    fun `더하기 연산자를 통해 두 Lottos를 합칠 수 있다`() {
        val lottoFactory = RangeLottoFactory()
        val lottos1 = Lottos.of(PurchaseCount.from(3), lottoFactory)
        val lottos2 = Lottos.of(PurchaseCount.from(4), lottoFactory)

        val lottos = lottos1 + lottos2
        assertAll(
            { assertThat(lottos.value.size).isEqualTo(7) },
            { assertThat(lottos.value).containsAll(lottos1.value) },
            { assertThat(lottos.value).containsAll(lottos2.value) }
        )
    }
}
