package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoFactoryTest {
    @Test
    fun `LottoFactory를 구현하여 Lotto를 만드는 객체를 생성할 수 있다`() {
        val lotto = Lotto.from(1, 2, 3, 4, 5, 6)
        val lottoFactory = object : LottoFactory {
            override fun create(): Lotto {
                return lotto
            }
        }

        assertThat(lottoFactory.create()).isEqualTo(lotto)
    }
}
