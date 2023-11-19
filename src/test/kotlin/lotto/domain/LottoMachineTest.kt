package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    @DisplayName("금액을 입력하면 구매할 수 있는 로또의 개수를 반환한다")
    @ParameterizedTest
    @CsvSource(
        value = [
            "1000:1",
            "10000:10",
            "1500:1",
            "500:0",
        ],
        delimiter = ':'
    )
    fun lottoCountShouldBeReturnByPaidPrice(price: Int, expected: Int) {
        // given
        val lottoMachine = LottoMachine()

        // when
        val actual = lottoMachine.payPriceAndGetCount(price)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @DisplayName("지불한 금액이 0원 이하일 경우 예외를 발생시킨다")
    @Test
    fun exceptionShouldBeThrowWhenPaidPriceIsLessThanZero() {
        // given
        val lottoMachine = LottoMachine()
        val price = -1000

        // when & then
        assertThatThrownBy { lottoMachine.payPriceAndGetCount(price) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("지불하는 금액은 0보다 커야합니다")
    }

    @DisplayName("로또를 구매한 갯수만큼 로또를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = [1, 10])
    fun generateTest(lottoCount: Int) {
        // given
        val lottoMachine = LottoMachine()

        // when
        val lotto = lottoMachine.generate(lottoCount)

        // then
        assertThat(lotto).hasSize(lottoCount)
    }

    @DisplayName("지불한 금액에 따라 로또를 반환한다")
    @Test
    fun buyTest() {
        // given
        val lottoMachine = LottoMachine()
        val price = 10_000

        // when
        val lotto = lottoMachine.buy(price)

        // then
        assertThat(lotto).hasSize(10)
    }
}