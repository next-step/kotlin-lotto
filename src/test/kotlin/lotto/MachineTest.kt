package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MachineTest {

    @Test
    fun `로또 기계는 금액을 전달 받는다`() {
        assertThat(Machine(10000).purchasePrice).isEqualTo(Machine(10000).purchasePrice)
    }

    @Test
    fun `입력 받은 금액으로 구매할 수 있는 로또의 갯수를 확인한다`() {
        assertThat(Machine(10002).lottoCount).isEqualTo(10)
    }

    @Test
    fun `구매 가능한 로또 수 만큼 랜덤 생성된 목록을 확인한다`() {
        val machine = Machine(10002)
        machine.purchase()

        assertThat(machine.lottoList.size).isEqualTo(10)
    }

    @Test
    fun `통계 기능을 확인한다`() {
        val machine = Machine(10002)
        machine.purchase()
        machine.statistics(
            "1, 2, 3, 4, 5, 6",
            listOf(
                Lotto(numbers = setOf(1, 2, 3, 4, 5, 6)),
                Lotto(numbers = setOf(1, 2, 3, 4, 10, 11)),
                Lotto(numbers = setOf(1, 2, 3, 10, 11, 12))
            )
        )
    }
}
