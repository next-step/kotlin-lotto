package lotto.model

import lotto.model.LottoEvaluator.countOfMatchNumber
import lotto.model.data.Lotto.Companion.toLotto
import lotto.model.data.LottoNumbers.Companion.toLottoNumbers
import lotto.model.data.Lottos
import lotto.model.data.Policy645
import lotto.model.data.Result
import lotto.model.data.Results
import lotto.model.data.Statistics
import lotto.model.data.Winning
import lotto.model.data.WinningLotto.Companion.toWinningLotto
import lotto.model.data.toLotto
import lotto.model.data.toLottoNumber
import lotto.view.input.LottosInputView
import lotto.view.input.ManualLottosInputView
import lotto.view.output.ConsoleOutputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.Integer.max

internal class RangeLottoBuilderTest {

    private val policy = Policy645()
    private lateinit var lottoBuilder: RangeLottoBuilder

    @BeforeEach
    fun setUp() {
        lottoBuilder = RangeLottoBuilder(policy)
    }

    @Test
    fun `1~45 사이 숫자 중 6개를 랜덤하게 뽑아내어 로또를 만든다`() {

        val lotto = lottoBuilder.createLotto()
        val rangeOfNumbers = policy.rangeOfNumbers
        val countOfNumberToSelect = policy.countOfNumberToSelect

        assertAll(
            { assertThat(lotto.numbers.filter { it !in rangeOfNumbers }).isEmpty() },
            { assertThat(lotto.numbers.size).isEqualTo(countOfNumberToSelect) },
            { assertThat(lotto.numbers.distinct().size).isEqualTo(countOfNumberToSelect) }
        )
    }

    @ParameterizedTest
    @CsvSource(
        "0,0", // purchase amount , purchasable lotto count
        "900,0",
        "1000,1",
        "1100,1",
        "11000,11",
    )
    fun `1000원의 배수로 갯수 만큼 로또를 생성한다`(purchaseAmount: Int, expectedCountOfLotto: Int) {

        val lottos = lottoBuilder.createLottosByAmount(purchaseAmount = purchaseAmount)
        assertThat(lottos.size).isEqualTo(expectedCountOfLotto)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5,6',6", // lotto numbers , expected match count when the winning number is 1,2,3,4,5,6
        "'1,2,3,4,5,16',5",
        "'1,2,3,4,15,16',4",
        "'1,2,3,14,15,16',3",
        "'1,2,13,14,15,16',2",
        "'1,12,13,14,15,16',1",
        "'11,12,13,14,15,16',0",
        "'11,12,3,14,15,6',2",
    )
    fun `1~45 사이 숫자 중 6개 당첨 번호를 만들어 일치 갯수를 계산한다`(lottoNumbers: String, expectedMatchCount: Int) {

        val winningNumbers = "1,2,3,4,5,6"
        val bonusBall = "7"
        val lotto = lottoNumbers.toLotto(policy)
        val winningLotto = winningNumbers.toLotto(policy)
            .toWinningLotto(policy, bonusBall.toLottoNumber())

        assertThat(winningLotto.countOfMatchNumber(lotto)).isEqualTo(expectedMatchCount)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5,6',2000000000", // lotto numbers , expected won money when the winning number is 1,2,3,4,5,6
        "'1,2,3,4,5,16',1500000",
        "'1,2,3,4,15,16',50000",
        "'1,2,3,14,15,16',5000",
        "'1,2,13,14,15,16',0",
        "'1,12,13,14,15,16',0",
        "'11,12,13,14,15,16',0",
        "'11,12,3,14,5,6',5000",
    )
    fun `일치 갯수에 따른 당청 종류 및 당첨 금액 를 판정한다`(lottoNumbers: String, expectedWonMoney: Int) {

        val winningNumbers = "1,2,3,4,5,6"
        val bonusBall = "7"
        val lotto = lottoNumbers.toLotto(policy)
        val winningLotto = winningNumbers.toLotto(policy)
            .toWinningLotto(policy, bonusBall.toLottoNumber())

        val result = LottoEvaluator.evaluate(winningLotto, lotto)
        assertThat(result.winning.winMoney).isEqualTo(expectedWonMoney)
    }

    @Test
    fun `여러 로또 (lottos)를 한번에 판정할 수 있는 기능`() {

        // given
        val lottoNumbers = "1,2,3,4,5,16" // 3등 1500000
        val winningNumbers = "1,2,3,4,5,6"
        val bonusBall = "7"
        val countOfLotto = 3

        val expectedWonMoney = countOfLotto * Winning.THIRD.winMoney
        val lottos = Lottos(countOfLotto) { lottoNumbers.toLotto(policy) }
        val winningLotto = winningNumbers.toLotto(policy)
            .toWinningLotto(policy, bonusBall.toLottoNumber())

        // when
        val results = LottoEvaluator.evaluate(winningLotto, lottos)

        // then
        assertThat(results.sumOf { it.winning.winMoney }).isEqualTo(expectedWonMoney)
    }

    @Test
    fun `당첨 통계를 계산한다 -  Statistics`() {

        // given
        val resultList = listOf(
            // 낙첨 1개,
            // 3등 4개,
            // 4등 3개,
            // 5등 1개,
            // 1등 1개,
            Result(lottoBuilder.createLotto(), Winning.LOST_GAME),
            Result(lottoBuilder.createLotto(), Winning.THIRD),
            Result(lottoBuilder.createLotto(), Winning.THIRD),
            Result(lottoBuilder.createLotto(), Winning.THIRD),
            Result(lottoBuilder.createLotto(), Winning.THIRD),

            Result(lottoBuilder.createLotto(), Winning.FIFTH),

            Result(lottoBuilder.createLotto(), Winning.FIRST),

            Result(lottoBuilder.createLotto(), Winning.FOURTH),
            Result(lottoBuilder.createLotto(), Winning.FOURTH),
            Result(lottoBuilder.createLotto(), Winning.FOURTH),
        )
        val results = Results(resultList)

        val expectedLottoCount = resultList.size
        val expectedTotalCost = expectedLottoCount * policy.priceOfLotto
        val expectedTotalWonAmount = resultList.sumOf { it.winning.winMoney }
        val expectedWinRatio = expectedTotalWonAmount.toDouble() / expectedTotalCost.toDouble()

        // when
        val statistics = Statistics(results, policy)

        // then
        assertAll(
            { assertThat(statistics.lottoCount).isEqualTo(expectedLottoCount) },
            { assertThat(statistics.totalCost).isEqualTo(expectedTotalCost) },
            { assertThat(statistics.totalWonAmount).isEqualTo(expectedTotalWonAmount) },
            { assertThat(statistics.yield).isEqualTo(expectedWinRatio) },

            { assertThat(statistics.winningCountMap[Winning.FIRST]).isEqualTo(1) },
            { assertThat(statistics.winningCountMap[Winning.THIRD]).isEqualTo(4) },
            { assertThat(statistics.winningCountMap[Winning.FOURTH]).isEqualTo(3) },
            { assertThat(statistics.winningCountMap[Winning.FIFTH]).isEqualTo(1) },
            { assertThat(statistics.winningCountMap[Winning.LOST_GAME]).isEqualTo(1) }
        )
    }

    @Test
    fun `당첨 통계를 출력한다`() {

        // given
        val resultList = listOf(
            // 낙첨 1개,
            // 3등 4개,
            // 4등 3개,
            // 5등 1개,
            // 1등 1개,
            Result(lottoBuilder.createLotto(), Winning.LOST_GAME),
            Result(lottoBuilder.createLotto(), Winning.THIRD),
            Result(lottoBuilder.createLotto(), Winning.THIRD),
            Result(lottoBuilder.createLotto(), Winning.THIRD),
            Result(lottoBuilder.createLotto(), Winning.THIRD),

            Result(lottoBuilder.createLotto(), Winning.FIFTH),

            Result(lottoBuilder.createLotto(), Winning.FIRST),

            Result(lottoBuilder.createLotto(), Winning.FOURTH),
            Result(lottoBuilder.createLotto(), Winning.FOURTH),
            Result(lottoBuilder.createLotto(), Winning.FOURTH),
        )
        val results = Results(resultList)
        val actualString = StringBuilder()
        val outputView = ConsoleOutputView(policy) { outString ->
            actualString.append(outString.toString())
            actualString.append("\n")
        }

        val expectedString = listOf(
            "당첨 통계",
            "----------",
            "3개 일치 (5000원) - 1개",
            "4개 일치 (50000원) - 3개",
            "5개 일치 (1500000원) - 4개",
            "5개 일치, 보너스 볼 일치 (30000000원) - 0개",
            "6개 일치 (2000000000원) - 1개",
            "총 수익률은 200615.50입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)"
        ).joinToString(separator = "\n", postfix = "\n")

        // when
        outputView.printResults(results)

        // then
        assertThat(actualString.toString()).isEqualTo(expectedString)
    }

    @ParameterizedTest
    @CsvSource(
        "0,0", // purchase amount , purchasable lotto count
        "900,0",
        "1000,1",
        "1100,1",
        "11000,11"
    )
    fun `콘솔입력을 통해 금액을 입력 받는다`(purchaseAmount: Int, expectedCountOfLotto: Int) {

        val manualLottoProvider = object : ManualLottosInputView {
            override fun readCountOfManualLotto(maxCount: Int): Int {
                return max(0, maxCount - 3) // 자동으로 3장, 나머지는 수동
            }

            override fun readManualLottos(count: Int): Lottos {
                return Lottos(count) { (1..6).map { it }.toLottoNumbers().toLotto(policy) }
            }
        }

        val lottosInputView = LottosInputView(policy, manualLottoProvider) { purchaseAmount }
        assertThat(lottosInputView.getInput().size).isEqualTo(expectedCountOfLotto)
    }
}
