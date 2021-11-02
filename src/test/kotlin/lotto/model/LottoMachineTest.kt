package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoMachineTest {

    private lateinit var machine: LottoMachine

    @BeforeEach
    fun setup() {
        machine = LottoMachine()
    }

    @ValueSource(ints = [0, 5, 10, 20, 6, 14])
    @ParameterizedTest(name = "발급 매수만큼의 로또가 발급되어야 한다.")
    fun lottoCount(size: Int) {
        val actual = machine.auto(size, 0).size
        assertThat(actual).isEqualTo(size)
    }

    @DisplayName("발급 매수가 0보다 작은 경우 RuntimeException 예외가 발생해야 한다.")
    @Test
    fun lottoNegative() {
        assertThrows<RuntimeException> {
            machine.auto(-1, 0)
        }
    }

    @DisplayName("로또 번호를 받으면 번호에 해당하는 로또를 반환해야 한다.")
    @Test
    fun lottoMachineManual() {
        val numbers = LottoNumbers.manual(1, 2, 3, 4, 5, 6)
        val actual = machine.manual(numbers)

        val expected = listOf(LottoCreator.manualZeroPrice(1, 2, 3, 4, 5, 6))
        assertThat(actual).isEqualTo(expected)
    }

    private fun LottoMachine.manual(numbers: LottoNumbers): List<Lotto> = manual(listOf(numbers), 0)
}
