package lotto

import lotto.domain.LottoLines
import lotto.domain.ManualLotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoLinesTest {
    @ParameterizedTest
    @CsvSource(
        "10000,10",
        "20000,20",
        "30000,30",
        "40000,40"
    )
    fun `로또 티켓(여러줄) 생성 테스트-모두 자동`(inputMoney: Int, gameCount: Int) {
        val totalNumber = inputMoney / LINE_PRICE
        val lottoTicket = LottoLines(totalNumber, ManualLotto())
        Assertions.assertThat(lottoTicket.getLines().filter { !it.manual }.size).isEqualTo(gameCount)
    }

    @ParameterizedTest
    @CsvSource(
        "10000,2,10",
        "20000,3,20",
        "30000,4,30",
        "40000,5,40"
    )
    fun `로또 티켓(여러줄) 생성 테스트-수동 생성`(inputMoney: Int, manualCount: Int, gameCount: Int) {
        val totalNumber = inputMoney / LINE_PRICE
        val numbersList = ManualLotto()
        for (count in 1..manualCount) {
            numbersList.add((1..45).toList().shuffled().take(6).sorted())
        }
        val lottoTicket = LottoLines(totalNumber, numbersList)
        val target = lottoTicket.getLines()
        Assertions.assertThat(target.filter { it.manual }.size).isEqualTo(manualCount)
        Assertions.assertThat(target.filter { !it.manual }.size).isEqualTo(gameCount - manualCount)
    }
}
