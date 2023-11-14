package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또 번호를 생성한다`() {
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
        assertThat(lotto.numbers.size).isEqualTo(Lotto.LOTTO_NUMBER_COUNT)
    }

    @Test
    fun `로또 번호는 6개여야 한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(
                listOf(
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5)
                )
            )
        }
    }

    @Test
    fun `로또 번호는 중복될 수 없다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(
                listOf(
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5),
                    LottoNumber.of(5)
                )
            )
        }
    }

    @Test
    fun `로또 번호가 일치하는 개수를 구한다`() {
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
        val winningLotto = WinningLotto(
            Lotto(
                listOf(
                    LottoNumber.of(1),
                    LottoNumber.of(2),
                    LottoNumber.of(3),
                    LottoNumber.of(4),
                    LottoNumber.of(5),
                    LottoNumber.of(7)
                )
            ),
            LottoNumber.of(6)
        )
        assertThat(lotto.getRank(winningLotto)).isEqualTo(LottoRank.SECOND)
    }
}
