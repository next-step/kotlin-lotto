package lotto.contoller

import lotto.model.data.Lottos
import lotto.model.data.Policy645
import lotto.model.data.Statistics
import lotto.model.data.WinningLotto
import lotto.model.data.WinningLotto.Companion.toWinningLotto
import lotto.model.data.toLotto
import lotto.model.data.toLottoNumber
import lotto.view.input.InputView
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoControllerTest {

    private val policy = Policy645()

    @ParameterizedTest
    @CsvSource(
        "'1,11,12,13,14,15',0", // lost game
        "'1,2,12,13,14,15',0", // lost game
        "'1,2,3,13,14,15',5000", // match 3
        "'1,2,3,4,14,15',50000", // match 4
        "'1,2,3,4,5,15',1500000", // match 5
        "'1,2,3,4,5,6',2000000000", // match 6
    )
    fun testWithDummyView(lottoNumbers: String, expectedWonAmount: Int) {
        // given
        val winningNumbers = "1,2,3,4,5,6"
        val bonusBall = "7"
        val policy = Policy645() // 한국 6/45 로또
        val controller = createController(lottoNumbers, winningNumbers, bonusBall)

        // when
        val statistics = Statistics(controller.executeGame(), policy)

        // then
        assertAll(
            { assertThat(statistics.lottoCount).isEqualTo(1) },
            { assertThat(statistics.totalCost).isEqualTo(policy.priceOfLotto) },
            { assertThat(statistics.totalWonAmount).isEqualTo(expectedWonAmount) }
        )
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,13,14,15',5000", // FIFTH
        "'1,2,3,4,14,15',50000", // FOURTH
        "'1,2,3,4,5,15',1500000", // THIRD
        "'1,2,3,4,5,7',30000000", // SECOND
        "'1,2,3,4,5,6',2000000000", // FIRST
    )
    fun `2등 3등 구분 판전 테스트`(lottoNumbers: String, expectedWonAmount: Int) {
        // given
        val winningNumbers = "1,2,3,4,5,6"
        val bonusBall = "7"
        val policy = Policy645() // 한국 6/45 로또
        val controller = createController(lottoNumbers, winningNumbers, bonusBall)

        // when
        val statistics = Statistics(controller.executeGame(), policy)

        // then
        org.junit.jupiter.api.assertAll(
            { Assertions.assertThat(statistics.lottoCount).isEqualTo(1) },
            { Assertions.assertThat(statistics.totalCost).isEqualTo(policy.priceOfLotto) },
            { Assertions.assertThat(statistics.totalWonAmount).isEqualTo(expectedWonAmount) }
        )
    }

    private fun createController(lottoNumbers: String, winningNumbers: String, bonusBall: String): LottoController {

        val lotto = lottoNumbers.toLotto(policy)
        val winningLotto = winningNumbers.toLotto(policy)
            .toWinningLotto(policy, bonusBall.toLottoNumber())

        val winningLottoInputView = object : InputView<WinningLotto> {
            override fun getInput() = winningLotto
        }

        val purchaseView = object : InputView<Lottos> {
            override fun getInput() = Lottos.of(lotto)
        }

        return LottoController(
            lottosInputView = purchaseView,
            winningLottoInputView = winningLottoInputView,
            outputView = null // headless test
        )
    }
}
