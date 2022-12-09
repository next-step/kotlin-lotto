package simulator.lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


internal class LottoMachineTest {
    @Test
    fun `요청받은 횟수 만큼 로또리스트를 생성한다`() {
        val numbersGenerator =
            NumberGenerator(Number.MIN_NUMBER, Number.MAX_NUMBER, Numbers.NUMBERS_COUNT)
        val machine = LottoMachine(numbersGenerator)
        val lottoList = machine.create(10)

        lottoList.count() shouldBe 10
    }
}
