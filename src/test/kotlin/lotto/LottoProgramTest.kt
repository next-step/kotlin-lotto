package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoProgramTest {
    @DisplayName("구입한 금액 만큼의 로또 장수를 반환한다.")
    @Test
    fun `when input amountOfMoney then return amountOfLotto`() {
        assertThat(LottoProgram.getAmountOfLotto(3000)).isEqualTo(3)
    }

    @DisplayName("입력한 금액이 천원단위가 아니면 UnitException을 던진다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 100, 1444, 2])
    fun `when input incorrect value then throw unit exception`(amountOfMoney: Int) {
        assertThatThrownBy {
            LottoProgram.getAmountOfLotto(amountOfMoney)
        }
            .isInstanceOf(UnitException::class.java)
            .hasMessage("1000원 단위만 입력할 수 있습니다.")
    }
}
