package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoTest {

    private val lotto = Lotto()

    @DisplayName(value = "입력받은 구입금액을 1000으로 나눈 몫을 출력한다.")
    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000])
    fun dividends(money: Int) {
        Assertions.assertThat(lotto.buy(money)).isSameAs(money / 1000)
    }
}