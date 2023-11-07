package lotto.domain

import lotto.domain.LottoManager.Companion.LOTTO_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoManagerTest {

    @ParameterizedTest
    @ValueSource(ints = [-1000, 0])
    fun `구입 금액이 양수가 아닌 경우 Exception을 던진다`(input: Int) {
        assertThatThrownBy { LottoManager(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구입 금액은 양의 정수여야 합니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [999, 2001])
    fun `구입 금액은 1000 단위여야 한다`(input: Int) {
        assertThatThrownBy { LottoManager(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구입 금액은 1000원 단위여야 합니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 5000])
    fun `구입 금액 1000원당 로또 하나를 발급한다`(input: Int) {
        val manager = LottoManager(input)
        manager.generateLottos()
        assertThat(manager.lottos.lottoList.size).isEqualTo(input / LOTTO_PRICE)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `보너스 번호가 숫자 범위를 벗어날 경우 Exception을 던진다`(input: Int) {
        val manager = LottoManager(1000)
        assertThatThrownBy { manager.setBonusNumber(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("보너스 번호는 1~45 사이의 숫자여야 합니다.")
    }

    @Test
    fun `보너스 번호가 당첨 번호중 하나와 일치할 경우 Exception을 던진다`() {
        val manager = LottoManager(1000)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        manager.setWinningNumbers(Lotto(winningNumbers))
        assertThatThrownBy { manager.setBonusNumber(winningNumbers.shuffled().take(1).first()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("보너스 번호는 당첨 번호와 중복될 수 없습니다.")
    }

    @Test
    fun `로또, 당첨번호, 보너스번호 설정 전 결과 요청시 Exception을 던진다`() {
        val manager = LottoManager(1000)
        assertThatThrownBy { manager.aggregate() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("발급된 로또가 없습니다")

        manager.generateLottos()
        assertThatThrownBy { manager.aggregate() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("당첨번호가 설정되지 않았습니다")

        manager.setWinningNumbers(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        assertThatThrownBy { manager.aggregate() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("보너스 번호가 설정되지 않았습니다")

        manager.setBonusNumber(7)
        assertThatNoException().isThrownBy { manager.aggregate() }
    }

    @Test
    fun `추첨 결과물 리스트를 반환한다`() {
        val money = 2000
        val manager = LottoManager(money)
        manager.generateLottos()
        manager.setWinningNumbers(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        manager.setBonusNumber(7)
        manager.aggregate()

        val result = manager.prizes
        assertThat(result).isInstanceOf(List::class.java)
        assertThat(result.size).isEqualTo(money / LOTTO_PRICE)
        assertThat(result.first()).isInstanceOf(Prize::class.java)
    }
}
