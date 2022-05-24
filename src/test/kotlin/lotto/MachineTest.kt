package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MachineTest {

    @Test
    fun `로또 기계는 금액을 전달 받는다`() {
        assertThat(Machine(10000).price).isEqualTo(Machine(10000).price)
    }

    @Test
    fun `입력 받은 금액으로 구매할 수 있는 로또의 갯수를 확인한다`() {
        assertThat(Machine(10002).lottoCount).isEqualTo(10)
    }

    @Test
    fun `구매 가능한 로또 수 만큼 랜덤 생성된 목록을 확인한다`() {
        assertThat(Machine(10002).lottoList.size).isEqualTo(10)
    }
}
