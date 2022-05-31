package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class WinningLottoTest {

    private lateinit var winningLotto: Set<LottoNumber>

    @BeforeEach
    internal fun setUp() {
        winningLotto = setOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
    }

    @Test
    fun `1에서 45 사이의 숫자가 있는 로또 하나를 생성 하고 당첨 번호를 동일한 조건으로 생성한다`() {
        val winningLotto = WinningLotto(winningLotto, LottoNumber(7))
        val containsAll = winningLotto.lottoNumbers.containsAll(
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
    fun `6자리가 아닐 시 예외처리 한다`() {
        val lottoNumbers = setOf(
            LottoNumber(2),
            LottoNumber(3)
        )

        assertThatIllegalArgumentException()
            .isThrownBy { WinningLotto(lottoNumbers, LottoNumber(4)) }
    }

    @Test
    fun `보너스 번호가 당첨번호와 중복일 경우 예외처리 한다`() {

        assertThatIllegalArgumentException()
            .isThrownBy { WinningLotto(winningLotto, LottoNumber(2)) }
    }

    @Test
    fun `당첨번호가 5개가 일치하고 보너스 당첨번호도 일치 할 때`() {

        val bonusNumber = LottoNumber(7)

        val lottoNumbers = setOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(7)
        )

        val winningLotto = WinningLotto(winningLotto, bonusNumber)

        assertAll("2등 당첨 일 때", {
            assertThat(winningLotto.matchCount(lottoNumbers)).isEqualTo(5)
            assertThat(winningLotto.matchBonus(lottoNumbers)).isTrue
        })
    }

    @Test
    fun `당첨번호가 5개가 일치하고 보너스 당첨번호도 일치 하지 않을 때`() {
        val bonusNumber = LottoNumber(7)

        val lottoNumbers = setOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(8)
        )

        val winningLotto = WinningLotto(winningLotto, bonusNumber)

        assertAll("번호 5개는 맞췄지만 보너스 번호는 맞추지 못했을 때", {
            assertThat(winningLotto.matchCount(lottoNumbers)).isEqualTo(5)
            assertThat(winningLotto.matchBonus(lottoNumbers)).isFalse
        })
    }

    @Test
    fun `로또 번호와 당첨 번호의 갯수 확인`() {

        val winningLotto = WinningLotto(winningLotto, LottoNumber(7))

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
