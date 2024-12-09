package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoPrice
import lotto.service.LottoService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoGameTest {
    private fun createLottoNumbers(vararg numbers: Int): List<LottoNumber> {
        return numbers.map { LottoNumber(it) }
    }

    @ParameterizedTest
    @CsvSource("1000", "2000", "3000")
    fun `구매한 로또 만큼 랜덤한 번호를 생성한다`(money: Int) {
        val lottoPrice = LottoPrice(money)
        val lottos = LottoService().purchase(lottoPrice)

        assertThat(lottos.size).isEqualTo(lottoPrice.calculatePurchaseCount())

        lottos.forEach {
            assertThat(it.numbers.distinct().size).isEqualTo(6)
        }
    }

    @Test
    fun `구매한 로또번호와 당첨번호가 3개 이상 일치하면 당첨된다`() {
        val purchaseLotto = Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(createLottoNumbers(1, 2, 3, 7, 8, 9))
        purchaseLotto.match(winningLotto)
    }

    @Test
    fun `구매한 로또번호와 당첨번호가 2개 이하 일치하면 낙첨된다`() {
        val purchaseLotto = Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(createLottoNumbers(1, 2, 3, 7, 8, 9))
        purchaseLotto.match(winningLotto)
    }

    @Test
    fun `3개 미만으로 일치하는 경우는 당첨 통계에서 제외된다`() {
        val tickets =
            listOf(
                Lotto(createLottoNumbers(1, 2, 45, 44, 43, 42)),
                Lotto(createLottoNumbers(1, 13, 45, 44, 43, 42)),
            )
        val winningNumbers = Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6))

        val winningResult = LottoService().calculateWinningResult(tickets, winningNumbers)

        assertThat(winningResult.getWinningCount(2)).isEqualTo(0)
        assertThat(winningResult.getWinningCount(1)).isEqualTo(0)
    }

    @Test
    fun `각 매칭 개수별 당첨 횟수를 체크한다`() {
        val tickets =
            listOf(
                Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6)),
                Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6)),
                Lotto(createLottoNumbers(1, 2, 3, 4, 5, 7)),
                Lotto(createLottoNumbers(1, 2, 3, 4, 7, 8)),
            )
        val winningNumbers = Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6))

        val winningResult = LottoService().calculateWinningResult(tickets, winningNumbers)

        assertThat(winningResult.getWinningCount(6)).isEqualTo(2)
        assertThat(winningResult.getWinningCount(5)).isEqualTo(1)
        assertThat(winningResult.getWinningCount(4)).isEqualTo(1)
    }

    @Test
    fun `당첨번호와 일치하는 번호가 없는 경우 빈 결과를 반환한다`() {
        val tickets =
            listOf(
                Lotto(createLottoNumbers(11, 22, 23, 24, 25, 26)),
            )
        val winningNumbers = Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6))

        val winningResult = LottoService().calculateWinningResult(tickets, winningNumbers)

        assertThat(winningResult.getWinningCount(3)).isEqualTo(0)
        assertThat(winningResult.getWinningCount(4)).isEqualTo(0)
        assertThat(winningResult.getWinningCount(5)).isEqualTo(0)
        assertThat(winningResult.getWinningCount(6)).isEqualTo(0)
    }

    @Test
    fun `1등 2등 3등의 로또를 정상적으로 체크한다`() {
        val tickets =
            listOf(
                Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6)),
                Lotto(createLottoNumbers(1, 2, 3, 4, 5, 7)),
                Lotto(createLottoNumbers(1, 2, 3, 4, 7, 8)),
            )
        val winningNumbers = Lotto(createLottoNumbers(1, 2, 3, 4, 5, 6))

        val winningResult = LottoService().calculateWinningResult(tickets, winningNumbers)

        assertThat(winningResult.getWinningCount(6)).isEqualTo(1)
        assertThat(winningResult.getWinningCount(5)).isEqualTo(1)
        assertThat(winningResult.getWinningCount(4)).isEqualTo(1)
    }
}
