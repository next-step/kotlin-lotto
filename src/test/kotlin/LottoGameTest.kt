import model.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGameTest {

    @Test
    @DisplayName("로또 숫자가 Lotto.Size 개 생성된다")
    fun `createLottoNumber`() {
        val lotto = Lotto.make()
        assertThat(lotto.number.size).isEqualTo(Lotto.SIZE)
    }

    @Test
    @DisplayName("구매 금액을 입력 받으면 구매 금액 / 로또 금액만큼 로또 목록이 생성된다")
    fun `createLottoList`() {
        val inputMoney = 14_000
        val lottoGame = LottoGame()
        val list = lottoGame.buy(Money(inputMoney))
        assertThat(list.size).isEqualTo(inputMoney / Money.LOTTO_PRICE)
    }

    @Test
    @DisplayName("로또 당첨 번호를 입력 받을 수 있다")
    fun `inputWinningLotto`() {
        val lottoNumber = setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet()
        val winningLotto = WinningLotto(lottoNumber, 7)
        assertThat(winningLotto).isNotNull
    }

    @Test
    @DisplayName("로또와 당첨 번호 사이의 matchResult를 알 수 있다")
    fun `getMatchCount`() {
        val lottoNumber = setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet()
        val winningLotto = WinningLotto(lottoNumber, 7)
        val lotto = Lotto(setOf(4, 5, 6, 7, 8, 9).map { LottoNumber.from(it) }.toSet())
        assertThat(winningLotto.rank(lotto)).isNotNull()
    }

    @Test
    @DisplayName("로또를 가지고  당첨 등수를 알 수 있다")
    fun `getRank`() {
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet()
        val winningLotto = WinningLotto(lottoNumber, 7)
        val lotto = Lotto(listOf(4, 5, 6, 7, 8, 9).map { LottoNumber.from(it) }.toSet())
        assertThat(winningLotto.rank(lotto)).isEqualTo(Rank.FIFTH)
    }

    @Test
    @DisplayName("로또를 가지고 2 등을 알 수 있다")
    fun `getRankSecond`() {
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet()
        val winningLotto = WinningLotto(lottoNumber, 7)
        val lotto = Lotto(listOf(2, 3, 4, 5, 6, 7).map { LottoNumber.from(it) }.toSet())
        assertThat(winningLotto.rank(lotto)).isEqualTo(Rank.SECOND)
    }

    @Test
    @DisplayName("로또를 가지고 3 등을 알 수 있다")
    fun `getRankThird`() {
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet()
        val winningLotto = WinningLotto(lottoNumber, 7)
        val lotto = Lotto(listOf(2, 3, 4, 5, 6, 8).map { LottoNumber.from(it) }.toSet())
        assertThat(winningLotto.rank(lotto)).isEqualTo(Rank.THIRD)
    }

    @Test
    @DisplayName("보너스 번호를 입력 받을 수 있다")
    fun `inputBonusLottoNumber`() {
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet()
        val winningLotto = WinningLotto(lottoNumber, 7)
        assertThat(winningLotto.bonusNumber).isEqualTo(7)
    }

    @Test
    @DisplayName("로또 숫자와 당첨 번호를 가지고 (같은 숫자의 수, 발생횟수, 당첨금액) 목록 생성된다")
    fun `getPrizeList`() {
        var list = lottoList()
        val winningLotto = WinningLotto(setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet(), 7)
        val winningStatList = WinningResult.of(list, winningLotto)
        println(winningStatList)
        assertThat(winningStatList).isNotEmpty
    }

    @Test
    @DisplayName("당첨 금액을 합산할 수 있다")
    fun `sumPrizeMoney`() {
        var list = lottoList()
        val winningLotto = WinningLotto(setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet(), 7)
        val winningStatList = WinningResult.of(list, winningLotto)
        assertThat(WinningResult.sum(winningStatList)).isGreaterThanOrEqualTo(0)
    }

    @Test
    @DisplayName("수익률을 계산 할 수 있다")
    fun `getEarningRate`() {
        var list = lottoList()
        val winningLotto = WinningLotto(list[0].number, 7)
        val winningStatList = WinningResult.of(list, winningLotto)
        val result = WinningResult.earningRate(winningStatList, Money(14000))
        assertThat(result).isGreaterThanOrEqualTo(0.0)
    }

    private fun lottoList(): List<Lotto> {
        var list = mutableListOf<Lotto>()
        repeat(10) {
            val lotto = Lotto.make()
            list.add(lotto)
        }
        return list.toList()
    }
}
