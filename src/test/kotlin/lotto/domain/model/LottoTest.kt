package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `Lotto는 발급받은 로또의 번호들을 보관한다`() {
        val lottoNumbers = setOf(
            LottoNumber[1],
            LottoNumber[2],
            LottoNumber[3],
            LottoNumber[4],
            LottoNumber[5],
            LottoNumber[6],
        )
        val lotto = Lotto(lottoNumbers)

        assertThat(lotto.numbers).isEqualTo(lottoNumbers)
    }

    @Test
    fun `Lotto의 숫자가 6개가 아니면 IllegalArgumentException이 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto.from(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `checkWith를 통해 WinningNumbers를 받아 당첨 순위를 확인할 수 있다`() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6), LottoNumber[7])

        assertThat(lotto.checkWith(winningNumbers)).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `default를 통해 테스트 등에서 쓰일 기본 Lotto 객체를 얻을 수 있다`() {
        val expected = Lotto(
            setOf(
                LottoNumber[1],
                LottoNumber[2],
                LottoNumber[3],
                LottoNumber[4],
                LottoNumber[5],
                LottoNumber[6]
            )
        )

        assertThat(Lotto.default()).isEqualTo(expected)
    }

    @Test
    fun `intersectCount를 통해 두 로또가 몇 개의 번호가 겹치는지 확인할 수 있다`() {
        val lotto1 = Lotto.from(listOf(1, 2, 3, 4, 5, 7))
        val lotto2 = Lotto.from(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto1.intersectCount(lotto2)).isEqualTo(5)
    }
}
