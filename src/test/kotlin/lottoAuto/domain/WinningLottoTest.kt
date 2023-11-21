package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `주어진 로또 리스트와 당첨 로또를 비교하여 당첨 등수를 반환한다`() {
        // given
        val bonusLottoNumber = 8.toLottoNumber()
        val lotto = Lotto(
            lottoNumbers = (4..9).map { it.toLottoNumber() }
        )
        val winningLotto = WinningLotto(
            lotto = lotto,
            bonusLottoNumber = bonusLottoNumber
        )
        val lottoList = listOf(
            Lotto((1..6).map { it.toLottoNumber() }),
            Lotto((4..9).map { it.toLottoNumber() }),
            Lotto((10..15).map { it.toLottoNumber() }),
            Lotto((3..8).map { it.toLottoNumber() })
        )

        // when
        val lottoRanks = winningLotto.rank(lottoList)

        // then
        assertEquals(LottoRank.FOURTH, lottoRanks.ranks[0])
        assertEquals(LottoRank.FIRST, lottoRanks.ranks[1])
        assertEquals(LottoRank.MISS, lottoRanks.ranks[2])
        assertEquals(LottoRank.BONUS, lottoRanks.ranks[3])
    }

    @Test
    fun `로또 번호가 6개가 아닐 경우 WinningLotto 생성시 IllegalArgumentException을 발생시킨다(Lotto 조합에 따른 효과)`() {
        // given
        val lottoNumbers = listOf(
            1.toLottoNumber(),
            2.toLottoNumber(),
            3.toLottoNumber(),
            4.toLottoNumber(),
            5.toLottoNumber()
        )

        assertThrows<IllegalArgumentException> { // then
            WinningLotto( // when
                lotto = Lotto(lottoNumbers),
                bonusLottoNumber = 6.toLottoNumber()
            )
        }
    }

    @Test
    fun `중복된 로또 번호가 들어왔을 경우 IllegalArgumentException을 발생시킨다`() {
        // given
        val lottoNumbers = listOf(
            1.toLottoNumber(),
            1.toLottoNumber(),
            2.toLottoNumber(),
            3.toLottoNumber(),
            4.toLottoNumber()
        )

        assertThrows<IllegalArgumentException> { // then
            WinningLotto( // when
                lotto = Lotto(lottoNumbers),
                bonusLottoNumber = 6.toLottoNumber()
            )
        }
    }

    @Test
    fun `당첨 로또 번호와 보너스 번호가 중복될 경우 IllegalArgumentException을 발생시킨다`() {
        // given
        val lottoNumbers = listOf(
            1.toLottoNumber(),
            2.toLottoNumber(),
            3.toLottoNumber(),
            4.toLottoNumber(),
            5.toLottoNumber(),
            6.toLottoNumber()
        )

        assertThrows<IllegalArgumentException> { // then
            WinningLotto( // when
                lotto = Lotto(lottoNumbers),
                bonusLottoNumber = 1.toLottoNumber()
            )
        }.also {
            assertEquals("보너스 번호는 당첨 번호와 중복될 수 없습니다.", it.message)
        }
    }
}
