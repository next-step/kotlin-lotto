package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(ints = [300, 400, 700, 800])
    fun `천원 미만 금액을 입력하면 예외가 발생한다`(price: Int) {
        val lottoMachine = LottoMachine()

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { lottoMachine.draw(price) }
            .withMessage("로또를 구매하려면 최소 1000원 이상의 금액이 필요합니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 1500, 2000, 3000, 4000])
    fun `로또를 구매하면 로또를 구매한 개수만큼 로또가 생성된다`(price: Int) {
        val lottoMachine = LottoMachine()

        val lotto = lottoMachine.draw(price)

        assertThat(lotto.size).isEqualTo(price / 1000)
    }
}
