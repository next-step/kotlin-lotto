package lotto

import lotto.LottoManager.Companion.LOTTO_PRICE
import lotto.util.Prize
import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `당첨번호 설정 전 결과를 요청하면 Exception을 던진다`() {
        val manager = LottoManager(1000)
        assertThatThrownBy { manager.getResult() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("로또 발급 및 당첨 번호 입력이 선행되어야 합니다")
    }

    @Test
    fun `추첨 결과물 리스트를 반환한다`() {
        val money = 2000
        val manager = LottoManager(money)
        manager.generateLottos()
        manager.setWinningNumbers(Lotto(listOf(1, 2, 3, 4, 5, 6)))

        val result = manager.getResult()
        assertThat(result).isInstanceOf(List::class.java)
        assertThat(result.size).isEqualTo(manager.lottoAmount)
        assertThat(result.first()).isInstanceOf(Prize::class.java)
    }
}
