package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `번호 리스트를 받는다면, 로또를 생성 요청을 한다면, 해당 번호로 구성된 로또를 생성한다`() {
        // given : 번호를 입력받는다면
        val numberList = listOf(1, 2, 3, 4, 5, 6)

        // when : 로또를 생성한다.
        val actual = LottoMachine.createLotto(numberList)

        // then : 해당 번호로 로또를 생성한다.
        assertThat(actual).isEqualTo(Lotto(numberList))
    }
}
