package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTests {
    @Test
    fun `로또 생성시 6개의 숫자를 가지고 있어야 한다`() {
        val lotto: Lotto = Lotto(generator = 순차적으로_증가하는_로또번호_제너레이터())

        assertThat(lotto.numbers.size)
            .isEqualTo(6)
    }

    @Test
    fun `로또 생성시 제너레이터에 의존해야한다`() {
        val lotto: Lotto = Lotto(generator = 순차적으로_증가하는_로또번호_제너레이터())

        assertThat(lotto.numbers)
            .containsExactlyInAnyOrder(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
    }

    fun 순차적으로_증가하는_로또번호_제너레이터(): LottoNumberGenerator {
        return object : LottoNumberGenerator {
            private var increase: Int = 1

            override val number: Int
                get() = increase++
        }
    }
}
