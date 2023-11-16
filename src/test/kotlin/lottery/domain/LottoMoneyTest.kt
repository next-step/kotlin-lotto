package lottery.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMoneyTest {

    @ParameterizedTest(name = "구매금액 {0}원, 수동 {1}장인 경우 자동은 {2}장")
    @CsvSource(
        "1000, 1, 0",
        "2000, 0, 2",
        "3000, 3, 0"
    )
    fun `로또 구매 금액과 수동 로또 구매 수를 입력받아 자동 로또 구매 수를 계산한다`(money: Int, manualLottoCount: Int, autoLottoCount: Int) {
        val lottoMoney = LottoMoney(money, manualLottoCount)

        lottoMoney.autoLottoCount shouldBe autoLottoCount
    }
}
