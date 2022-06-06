package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTest {

    @Test
    fun `로또는 6개의 로또 넘버를 가진다`() {
        val lotto = Lotto(
            listOf(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
            )
        )
        assertThat(lotto.numbers).hasSize(6)
    }

    @Test
    fun `로또 숫자가 6개보다 부족하면 exception`() {
        assertThrows<IllegalArgumentException> {
            Lotto(
                listOf(
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5),
                )
            )
        }
    }

    @Test
    fun `로또 숫자가 6개보다 많으면 exception`() {
        assertThrows<IllegalArgumentException> {
            Lotto(
                listOf(
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5),
                    LottoNumber.of(6),
                    LottoNumber.of(7),
                )
            )
        }
    }
}
