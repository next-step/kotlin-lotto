package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `로또 당첨을 확인한다`() {
        // given
        val winningLotto = WinningLotto(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
            )
        )

        val lotto = Lotto(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
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
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
            )
        )

        val lotto = Lotto(
            listOf(
                LottoNumber.from(10),
                LottoNumber.from(20),
                LottoNumber.from(30),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
            )
        )

        // when
        val sameNumberSize = winningLotto.countSameNumber(lotto)

        // then
        assertNotEquals(Lotto.LOTTO_SIZE, sameNumberSize)
    }
}
