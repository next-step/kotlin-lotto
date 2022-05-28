package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class WinningLottoTest {
    @Test
    fun `객체 생성`() {
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
    fun `유효성 검사`() {
        val lottoNumbers = setOf(
            LottoNumber(2),
            LottoNumber(3)
        )

        assertThatIllegalArgumentException()
            .isThrownBy { WinningLotto(lottoNumbers) }
    }

    @Test
    fun `match `() {
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
