package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoManagerTest {

    @ParameterizedTest
    @ValueSource(strings = ["1000", "2000", "3000"])
    fun `primary 생성자로 구입금액을 문자열로 받아 정수형으로 기록한다`(input: String) {
        val lottoManager = LottoManager(input)
        assertThat(lottoManager.purchased).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1000", "100,000"])
    fun `구입 금액이 음수일 경우 Exception을 던진다`(input: String) {
        assertThatThrownBy { LottoManager(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("구입 금액은 숫자로만 표현된 양수여야 합니다.")
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
        assertThat(manager.getLottoList().size).isEqualTo(input.toInt() / 1000)
    }
}
