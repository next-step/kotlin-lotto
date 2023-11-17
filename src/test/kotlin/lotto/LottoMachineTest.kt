package lotto

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.domain.LottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `번호 리스트를 받았다면, 로또를 생성 요청을 했을 때, 해당 번호로 구성된 로또를 생성한다`() {
        // given : 번호를 리스트를 받는다.
        val numberList = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = LottoNumber.createLottoNumbers(numberList)

        // when : 로또를 생성한다.
        val actual = LottoMachine.createSelectLotto(lottoNumbers)
        val expect = Lotto(lottoNumbers)

        // then : 해당 번호로 로또를 생성한다.
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `구매 로또와 추첨된 로또를 받았다면, 당첨 확인을 요청했을 때, 당첨 등수를 반환한다`() {
        // given : 구매 로또 리스트와 추첨된 로또를 받는다.
        val winningNumberList = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = Lotto(LottoNumber.createLottoNumbers(winningNumberList))
        val purchaseNumberList = listOf(1, 2, 3, 4, 5, 7)
        val purchaseLotto = Lotto(LottoNumber.createLottoNumbers(purchaseNumberList))

        // when : 당첨 여부를 확인을 요청한다.
        val actual = LottoMachine.checkLotto(winningLotto, purchaseLotto)

        // then : 당첨 등수를 반환한다.
        assertThat(actual).isEqualTo(LottoRanking.SecondPlace)
    }

    @Test
    fun `구매 금액과 당첨 통계를 받았고, 수익률을 요청한다면, 수익률을 반환한다`() {
        // given : 구매 금액과 당첨 통계를 받는다.
        val cash = 6000
        val winningStatus = mutableMapOf(
            LottoRanking.SecondPlace to 2,
            LottoRanking.ThirdPlace to 1,
            LottoRanking.FourthPlace to 2,
            LottoRanking.None to 1
        )

        // when : 수익률을 요청한다.
        val winningRate = LottoMachine.createWinningRate(cash, winningStatus)

        // then : 수익률을 반환한다.
        assertThat(winningRate).isEqualTo(510f)
    }
}
