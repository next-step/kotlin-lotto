package lottery.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `입력받은 로또 당첨 번호와 보너스 번호가 동일한 경우 오류를 반환한다`() {
        assertThrows<IllegalArgumentException> {
            val winningLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
            val bonusNumber = 1

            WinningLotto(winningLottoNumbers, bonusNumber)
        }
    }

    @Test
    fun `당첨 로또 객체는 당첨 로또와 보너스 번호를 가진다`() {
        val winningLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val lotto = WinningLotto(winningLottoNumbers, bonusNumber)

        lotto.winningLotto.shouldBeInstanceOf<Lotto>()
        lotto.bonusNumber.lottoNumber shouldBe 7
    }

    @Test
    fun `당첨 로또 객체는 입력받은 로또 객체를 받아 일치하는 숫자 갯수를 반환한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winningLotto = WinningLotto(lottoNumbers, bonusNumber)
        val userLotto = Lotto.of(lottoNumbers)

        winningLotto.getMatchResult(userLotto) shouldBe 6
    }

    @Test
    fun `당첨 로또 객체는 입력받은 로또 객체를 받아 보너스 번호 일치여부를 반환한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winningLotto = WinningLotto(lottoNumbers, bonusNumber)
        val userLotto = Lotto.of(lottoNumbers)

        winningLotto.getBonusMatchResult(userLotto) shouldBe false
    }
}
