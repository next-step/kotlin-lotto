import model.LottoNumber
import model.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGameTest {

    @Test
    @DisplayName("로또 숫자가 6개 생성된다")
    fun `createLottoNumber`() {
    }

    @Test
    @DisplayName("구매 금액을 입력 받으면 구매 금액 / 로또 금액만큼 로또 목록이 생성된다")
    fun `createLottoList`() {
        val inputMoney = 14_000
        val lottoGame = LottoGame()
        val list = lottoGame.buy(inputMoney)
        assertThat(list.size).isEqualTo(inputMoney / LottoGame.LOTTO_PRICE)
    }

    @Test
    @DisplayName("로또 당첨 번호를 입력 받을 수 있다")
    fun `inputWinningLotto`() {
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val winningLotto = WinningLotto(lottoNumber, 7)
        assertThat(winningLotto).isNotNull
    }

    @Test
    @DisplayName("로또와 당첨 번호 사이의 matchCount를 알 수 있다")
    fun `getMatchCount`() {
    }

    @Test
    @DisplayName("보너스 번호를 입력 받을 수 있다")
    fun `inputBonusLottoNumber`() {
    }

    @Test
    @DisplayName("로또 숫자와 당첨 번호를 가지고 (같은 숫자의 수, 발생횟수, 당첨금액) 목록 생성된다")
    fun `getPrizeList`() {
    }

    @Test
    @DisplayName("당첨 금액을 합산할 수 있다")
    fun `sumPrizeMoney`() {
    }

    @Test
    @DisplayName("수익률을 계산 할 수 있다")
    fun `getEarningRate`() {
    }
}
