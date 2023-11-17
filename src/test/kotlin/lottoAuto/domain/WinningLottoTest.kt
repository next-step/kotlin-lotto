package lottoAuto.domain

import lottoAuto.domain.LottoNumber.Companion.toLottoNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `로또 당첨을 확인한다`() {
        // given
        val winningLotto = WinningLotto(
            listOf(
                1.toLottoNumber(),
                2.toLottoNumber(),
                3.toLottoNumber(),
                4.toLottoNumber(),
                5.toLottoNumber(),
                6.toLottoNumber()
            )
        )

        val lotto = Lotto(
            listOf(
                1.toLottoNumber(),
                2.toLottoNumber(),
                3.toLottoNumber(),
                4.toLottoNumber(),
                5.toLottoNumber(),
                6.toLottoNumber()
            )
        )

        // when
        val sameNumberSize = winningLotto.countSameNumber(lotto)

        // then
        assertEquals(Lotto.LOTTO_SIZE, sameNumberSize)
    }

    @Test
    fun `로또 당첨 탈락을 확인한다`() {
        // given
        val winningLotto = WinningLotto(
            listOf(
                1.toLottoNumber(),
                2.toLottoNumber(),
                3.toLottoNumber(),
                4.toLottoNumber(),
                5.toLottoNumber(),
                6.toLottoNumber()
            )
        )

        val lotto = Lotto(
            listOf(
                10.toLottoNumber(),
                20.toLottoNumber(),
                30.toLottoNumber(),
                4.toLottoNumber(),
                5.toLottoNumber(),
                6.toLottoNumber()
            )
        )

        // when
        val sameNumberSize = winningLotto.countSameNumber(lotto)

        // then
        assertNotEquals(Lotto.LOTTO_SIZE, sameNumberSize)
    }
}
