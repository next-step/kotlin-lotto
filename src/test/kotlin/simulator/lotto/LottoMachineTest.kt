package simulator.lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


internal class LottoMachineTest {
    @Test
    fun `요청받은 횟수 만큼 로또리스트를 생성한다`() {
        val numbersGenerator =
            NumberGenerator(Numbers.MAX_NUMBER, Numbers.MIN_NUMBER, Numbers.NUMBERS_COUNT)
        val machine = LottoMachine(numbersGenerator)
        val lottoList = machine.create(10)

        assertThat(lottoList.count()).isEqualTo(10)
    }
}
