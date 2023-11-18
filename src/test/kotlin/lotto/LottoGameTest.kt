package lotto

import lotto.data.Lotto
import lotto.data.LottoNumber
import lotto.data.LottoRanking
import lotto.domain.RandomLogic
import lotto.service.LottoGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `금액을 입력받았다면, 로또를 구매한을 떄, 최대 수량으로 구매를 한다`() {
        // given : 금액을 입력 받는다.
        val cash = 4500
        val lottoGame = LottoGame(RandomLogic())

        // when : 로또를 구매한다.
        val lottoList = lottoGame.buyLotto(cash)

        // then : 입력 받은 금액의 최대 수량의 로또를 구매한다.
        assertThat(lottoList.size).isEqualTo(4)
    }

    @Test
    fun `로또 구매와 당첨 번호를 입력 했다면, 당첨을 확인을 요청할 때, 당첨 통계를 반환한다`() {
        // given : 로또 구매와 당첨 번호를 입력한다.
        // 2등 - 2개, 3등 - 1개, 4등 - 1개
        val winningNumberList = listOf(1, 2, 3, 4, 5, 6)

        val purchaseLottoNumbers1 = LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 7))
        val purchaseLottoNumbers2 = LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 5, 7))
        val purchaseLottoNumbers3 = LottoNumber.createLottoNumbers(listOf(1, 2, 3, 4, 7, 8))
        val purchaseLottoNumbers4 = LottoNumber.createLottoNumbers(listOf(1, 2, 3, 7, 8, 9))
        val purchaseLottoNumbers5 = LottoNumber.createLottoNumbers(listOf(1, 2, 6, 7, 8, 9))
        val purchaseLottoNumbers6 = LottoNumber.createLottoNumbers(listOf(11, 12, 13, 14, 15, 16))

        val purchaseLotto1 = Lotto((purchaseLottoNumbers1))
        val purchaseLotto2 = Lotto((purchaseLottoNumbers2))
        val purchaseLotto3 = Lotto((purchaseLottoNumbers3))
        val purchaseLotto4 = Lotto((purchaseLottoNumbers4))
        val purchaseLotto5 = Lotto((purchaseLottoNumbers5))
        val purchaseLotto6 = Lotto((purchaseLottoNumbers6))

        val purchaseLottoList =
            listOf(purchaseLotto1, purchaseLotto2, purchaseLotto3, purchaseLotto4, purchaseLotto5, purchaseLotto6)

        val lottoGame = LottoGame(RandomLogic())

        // when : 당첨을 확인을 요청한다.
        val winningStats = lottoGame.getWinningStats(winningNumberList, purchaseLottoList)

        // then : 당첨 통계를 확인한다.
        val expect = mutableMapOf(
            LottoRanking.SecondPlace to 2,
            LottoRanking.ThirdPlace to 1,
            LottoRanking.FourthPlace to 2,
            LottoRanking.None to 1
        )
        assertThat(winningStats).isEqualTo(expect)
    }
}
