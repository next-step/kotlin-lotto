package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `번호 리스트를 받았다면, 로또를 생성 요청을 했을 때, 해당 번호로 구성된 로또를 생성한다`() {
        // given : 번호를 입력받는다면
        val numberList = listOf(1, 2, 3, 4, 5, 6)

        // when : 로또를 생성한다.
        val actual = LottoMachine.createLotto(numberList)

        // then : 해당 번호로 로또를 생성한다.
        assertThat(actual).isEqualTo(Lotto(numberList))
    }

    @Test
    fun `구매 로또와 추첨된 로또를 받았다면, 당첨 확인을 요청했을 때, 당첨 등수를 반환한다`() {
        // given : 구매 로또 리스트와 추첨된 로또를 받는다.
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val purchaseLotto1 = Lotto(listOf(1, 2, 3, 4, 5, 8))

        // when : 당첨 여부를 확인을 요청한다.
        val actual = LottoMachine.checkLotto(winningLotto, purchaseLotto1)

        // then : 당첨 등수를 반환한다.
        assertThat(actual).isEqualTo(LottoRanking.SecondPlace)
    }
}
