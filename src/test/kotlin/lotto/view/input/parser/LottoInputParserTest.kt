package lotto.view.input.parser

import calcaulator.util.toIntList
import lotto.model.data.Policy645
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoInputParserTest {

    private val policy = Policy645()
    private lateinit var lottoInputParser: LottoInputParser

    @BeforeEach
    fun setUp() {
        lottoInputParser = LottoInputParser(policy)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,2,3,4,5,6,7", // lage case
            "1,2,3,4", // small case
            "1,2,3,4,15,46", // over rage
            "1,2,3,14,15,50", // over rage
            "0,2,13,14,15,16", // under Range
            "1,12,100,14,15,16" //over rage
        ]
    )
    fun `잘못된 로또 번호 입력 체크 `(lottoNumberString: String) {

        assertThrows<IllegalArgumentException> {
            lottoInputParser.parseValue(lottoNumberString)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,2,3,4,5,6",
            "45,44,43,42,41,40"
        ]
    )
    fun `정상 로또 번호 입력 체크 `(lottoNumberString: String) {

        val expectedString = lottoNumberString.toIntList(delimiter = Regex(","))
            .distinct().sorted().joinToString(",")

        assertThat(lottoInputParser.parseValue(lottoNumberString).numbers.joinToString(","))
            .isEqualTo(expectedString)
    }
}
