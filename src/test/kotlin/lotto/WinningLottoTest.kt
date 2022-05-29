package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @Test
    fun `1에서 45 사이의 숫자가 있는 로또 하나를 생성`() {
        val lottoNumbers = setOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val winningLotto = WinningLotto(lottoNumbers)
        val containsAll = winningLotto.get.containsAll(
            setOf(
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(1),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        assertThat(containsAll).isTrue
    }

    @Test
    fun `6자리가 아닐 시 예외처리`() {
        val lottoNumbers = setOf(
            LottoNumber(2),
            LottoNumber(3)
        )

        assertThatIllegalArgumentException()
            .isThrownBy { WinningLotto(lottoNumbers) }
    }

    @Test
    fun `로또 번호와 당첨 번호의 갯수 확인`() {
        val lottoNumbers = setOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val winningLotto = WinningLotto(lottoNumbers)

        val matchCount = winningLotto.matchCount(
            setOf(
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(1),
                LottoNumber(11),
                LottoNumber(5),
                LottoNumber(6)
            )
        )

        assertThat(matchCount).isEqualTo(5)
    }
}
