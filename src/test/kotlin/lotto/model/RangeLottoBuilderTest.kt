package lotto.model

import lotto.model.data.Policy645
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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
        "0,0",
        "900,0",
        "1000,1",
        "1100,1",
        "11000,11",
    )
    fun `1000원의 배수로 갯수 만큼 로또를 생성한다`(purchaseAmount: Int, expectedCountOfLotto: Int) {

        val lottos = lottoBuilder.createLottosByAmount(purchaseAmount = purchaseAmount)
        assertThat(lottos.lottoList.size).isEqualTo(expectedCountOfLotto)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5,6',6",
        "'1,2,3,4,5,16',5",
        "'1,2,3,4,15,16',4",
        "'1,2,3,14,15,16',3",
        "'1,2,13,14,15,16',2",
        "'1,12,13,14,15,16',1",
        "'11,12,13,14,15,16',0",
        "'11,12,3,14,15,6',2",
    )
    fun `1~45 사이 숫자 중 6개 당첨 번호를 만들어 일치 갯수를 계산한다`(lottoNumberString: String, expectedMatchCount: Int) {

        val winningLottoNumber = "1,2,3,4,5,6"

        val lotto = StringLottoBuilder(lottoNumberString).createLotto()
        val winningLotto = StringLottoBuilder(winningLottoNumber).createLotto()

        assertThat(winningLotto.countOfMatchNumber(lotto)).isEqualTo(expectedMatchCount)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5,6',2000000000",
        "'1,2,3,4,5,16',1500000",
        "'1,2,3,4,15,16',50000",
        "'1,2,3,14,15,16',5000",
        "'1,2,13,14,15,16',0",
        "'1,12,13,14,15,16',0",
        "'11,12,13,14,15,16',0",
        "'11,12,3,14,5,6',5000",
    )
    fun `일치 갯수에 따른 당청 종류 및 당첨 금액 를 판정한다`(lottoNumberString: String, expectedWonMoney: Int) {

        val winningLottoNumber = "1,2,3,4,5,6"
        val lotto = StringLottoBuilder(lottoNumberString).createLotto()
        val winningLotto = StringLottoBuilder(winningLottoNumber).createLotto()

        val winning = LottoEvaluator.evaluate(winningLotto, lotto)
        assertThat(winning.winMoney).isEqualTo(expectedWonMoney)
    }
}
