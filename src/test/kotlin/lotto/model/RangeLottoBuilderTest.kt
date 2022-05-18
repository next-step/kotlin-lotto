package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RangeLottoBuilderTest {

    private lateinit var lottoBuilder: RangeLottoBuilder
    private val rangeOfNumbers = 1..45
    private val countOfNumberToSelect = 6
    private val priceOfLotto = 1000

    @BeforeEach
    fun setUp() {
        lottoBuilder = RangeLottoBuilder(rangeOfNumbers, countOfNumberToSelect, priceOfLotto)
    }

    @Test
    fun `1~45 사이 숫자 중 6개를 랜덤하게 뽑아내어 로또를 만든다`() {

        val lotto = lottoBuilder.createLotto()

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
}
