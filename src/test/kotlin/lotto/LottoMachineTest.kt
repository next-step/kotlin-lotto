package lotto

import lotto.domain.Lotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumberList
import lotto.domain.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMachineTest {

    @Test
    fun `로또를 구매할 수 있다`() {
        val lottoMachine: LottoMachine = LottoMachine()

        val lottoList: List<Lotto> = lottoMachine.buyLottoList(Lotto.LOTTO_PRICE)

        assertThat(lottoList).hasSize(1)
    }

    @Test
    fun `로또를 여러 개 구매할 수 있다`() {
        val lottoMachine: LottoMachine = LottoMachine()

        val lottoList: List<Lotto> = lottoMachine.buyLottoList(Lotto.LOTTO_PRICE * 2)

        assertThat(lottoList).hasSize(2)
    }

    @ParameterizedTest
    @CsvSource("1,2,3,4,5,6,1,2,3,4,5,7,SECOND_WITH_BONUS,6", "1,2,3,4,5,6,1,2,3,4,7,8,THIRD,10", "1,2,3,4,5,6,1,2,3,7,8,9,FOURTH,10", "1,2,3,4,5,6,1,2,7,8,9,10,MISS,10")
    fun `로또 결과를 얻을 수 있다`(first: Int, second: Int, third: Int, fourth: Int, fifth: Int, sixth: Int, winningFirst: Int, winningSecond: Int, winningThird: Int, winningFourth: Int, winningFifth: Int, winningSixth: Int, expected: LottoRank, bonusNumber: Int) {
        val lottoMachine: LottoMachine = LottoMachine()

        val lottoNumberList: LottoNumberList = LottoNumberList(listOf(first, second, third, fourth, fifth, sixth))
        val lotto: Lotto = Lotto(lottoNumberList)

        val winningNumberList: LottoNumberList = LottoNumberList(listOf(winningFirst, winningSecond, winningThird, winningFourth, winningFifth, winningSixth))
        val winningLotto: Lotto = Lotto(winningNumberList)

        val lottoRank: LottoRank = lottoMachine.getLottoRank(lotto, winningLotto, bonusNumber)

        assertThat(lottoRank).isEqualTo(expected)
    }
}
