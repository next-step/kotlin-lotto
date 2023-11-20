package lotto.domain

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.data.WinningLotto
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
    fun `구매 로또와 당첨 로또를 받았다면, 당첨 확인을 요청했을 때, 당첨 등수를 반환한다`() {
        // given : 구매 로또 리스트와 추첨된 로또를 받는다.
        val winningNumberList = listOf(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoNumber.from(7)
        val winningLotto = WinningLotto(Lotto(LottoNumber.createLottoNumbers(winningNumberList)), bonusLottoNumber)

        val purchaseNumberList = listOf(1, 2, 3, 4, 5, 8)
        val purchaseLotto = Lotto(LottoNumber.createLottoNumbers(purchaseNumberList))

        // when : 당첨 여부를 확인을 요청한다.
        val actual = LottoMachine.checkLotto(purchaseLotto, winningLotto)

        // then : 당첨 등수를 반환한다.
        assertThat(actual).isEqualTo(LottoRanking.ThirdPlace)
    }

    @Test
    fun ` 2등 당첨 시나리오`() {
        // given : 보너스 번호를 포함해 일치하는 숫자가 6개인 구성의 로또를 받는다.
        val winningNumberList = listOf(1, 2, 3, 4, 5, 6)
        val bonusLottoNumber = LottoNumber.from(7)
        val winningLotto = WinningLotto(Lotto(LottoNumber.createLottoNumbers(winningNumberList)), bonusLottoNumber)

        val purchaseNumberList = listOf(1, 2, 3, 4, 5, 7)
        val purchaseLotto = Lotto(LottoNumber.createLottoNumbers(purchaseNumberList))

        // when : 당첨 확인을 요청한다
        val actual = LottoMachine.checkLotto(purchaseLotto, winningLotto)

        // then : 2등이 담첨된다.
        assertThat(actual).isEqualTo(LottoRanking.SecondPlace)
    }

    @Test
    fun `구매 금액과 당첨 통계를 받았고, 수익률을 요청한다면, 수익률을 반환한다`() {
        // given : 구매 금액과 당첨 통계를 받는다.
        val cash = 6000
        val winningStatus = mutableMapOf(
            LottoRanking.ThirdPlace to 2,
            LottoRanking.FourthPlace to 1,
            LottoRanking.FifthPlace to 2,
            LottoRanking.None to 1
        )

        // when : 수익률을 요청한다.
        val winningRate = LottoMachine.createWinningRate(cash, winningStatus)

        // then : 수익률을 반환한다.
        assertThat(winningRate).isEqualTo(510f)
    }

    @Test
    fun `당첨 로또와 보너스 번호를 받고, 당첨 로또 번호 생성을 요청할때, 당첨 로또번호가 반환된다`() {
        // given : 1등 당첨 번호, 보너스 번호
        val numberList = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumber = LottoNumber.createLottoNumbers(numberList)
        val bonusNumber = 8

        // when : 당첨 번호
        val actual = LottoMachine.createWinningLotto(numberList, bonusNumber)

        // then : 당첨 로또 생성.
        val lotto = LottoMachine.createSelectLotto(lottoNumber)
        val expected = WinningLotto(lotto, LottoNumber.from(bonusNumber))

        assertThat(actual).isEqualTo(expected)
    }
}
