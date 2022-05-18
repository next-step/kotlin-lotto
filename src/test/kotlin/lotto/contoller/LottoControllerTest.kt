package lotto.contoller

import lotto.model.LottoBuilder
import lotto.model.data.Lotto
import lotto.model.data.Lotto.Companion.toLotto
import lotto.model.data.Policy645
import lotto.model.data.Statistics
import lotto.util.toBlankRemovedIntList
import lotto.view.input.InputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoControllerTest {

    @ParameterizedTest
    @CsvSource(
        "'1,11,12,13,14,15',0", // lost game
        "'1,2,12,13,14,15',0", // lost game
        "'1,2,3,13,14,15',5000", // match 3
        "'1,2,3,4,14,15',50000", // match 4
        "'1,2,3,4,5,15',1500000", // match 5
        "'1,2,3,4,5,6',2000000000", // match 6
    )
    fun testWithDummyView(lottiNumber: String, expectedWonAmount: Int) {
        // given
        val winningNumber = "1,2,3,4,5,6"
        val policy = Policy645() // 한국 6/45 로또
        val controller = createController(lottiNumber, winningNumber)

        // when
        val statistics = Statistics(controller.executeGame(), policy)

        // then
        org.junit.jupiter.api.assertAll(
            { assertThat(statistics.lottoCount).isEqualTo(1) },
            { assertThat(statistics.totalCost).isEqualTo(policy.priceOfLotto) },
            { assertThat(statistics.totalWonAmount).isEqualTo(expectedWonAmount) }
        )
    }

    private fun createController(lottoNumberString: String, winningNumber: String): LottoController {
        val lottoNumber = lottoNumberString.toBlankRemovedIntList()
        val winningNumber = winningNumber.toBlankRemovedIntList()
        val lottoBuilder = object : LottoBuilder {
            override fun createLotto(): Lotto {
                return lottoNumber.toLotto()
            }
        }

        val winningLottoInputView = object : InputView<Lotto> {
            override fun getInput(): Lotto {
                return winningNumber.toLotto()
            }
        }

        val purchaseView = object : InputView<Int> {
            override fun getInput() = 1
        }

        return LottoController(
            lottoBuilder = lottoBuilder,
            lottoCountInputView = purchaseView,
            winningLottoInputView = winningLottoInputView,
            outputView = null // headless test
        )
    }
}
