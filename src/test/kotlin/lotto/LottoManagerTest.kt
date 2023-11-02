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
    @ValueSource(strings = ["1000", "2000", "3000"])
    fun `primary 생성자로 구입금액을 문자열로 받아 정수형으로 기록한다`(input: String) {
        val lottoManager = LottoManager(input)
        assertThat(lottoManager.purchased).isEqualTo(input.toInt())
    }

    @Test
    fun `구입 금액이 양수가 아닌 경우 Exception을 던진다`() {
        assertThatThrownBy { LottoManager("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구입 금액은 양의 정수여야 합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["999", "2001"])
    fun `구입 금액은 1000 단위여야 한다`(input: String) {
        assertThatThrownBy { LottoManager(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구입 금액은 1000원 단위여야 합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1000", "5000"])
    fun `구입 금액 1000원당 로또 하나를 발급한다`(input: String) {
        val manager = LottoManager(input)
        assertThat(manager.getLottoList().size).isEqualTo(input.toInt() / LOTTO_PRICE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4", "1,2,3,4,5,6,7"])
    fun `당첨 번호가 6개가 아닌 경우 Exception을 던진다`(input: String) {
        val manager = LottoManager("1000")
        assertThatThrownBy { manager.setWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("당첨 번호는 6개의 숫자여야 합니다.")
    }

    @Test
    fun `당첨번호 설정 전 결과를 요청하면 Exception을 던진다`() {
        val manager = LottoManager("1000")
        assertThatThrownBy { manager.getResult() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("로또 발급 및 당첨 번호 입력이 선행되어야 합니다")
    }

    @Test
    fun `추첨 결과물 리스트를 반환한다`() {
        val manager = LottoManager("1000")
        manager.setWinningNumbers("1,2,3,4,5,6")

        val result = manager.getResult()
        assertThat(result).isInstanceOf(List::class.java)
        assertThat(result).isNotEmpty()
        assertThat(result.first()).isInstanceOf(Prize::class.java)
    }
}
