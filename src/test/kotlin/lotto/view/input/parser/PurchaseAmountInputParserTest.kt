package lotto.view.input.parser

import lotto.model.data.ParseResult
import lotto.model.data.Policy645
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PurchaseAmountInputParserTest {

    private val policy = Policy645()
    private lateinit var purchaseAmountInputParser: PurchaseAmountInputParser

    @BeforeEach
    fun setUp() {
        purchaseAmountInputParser = PurchaseAmountInputParser(policy)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "0", // under 1000
            "900", // under 1000
            "1100", //  rest 100
            "111000", // over 100000
            "150000" // over 100000
        ]
    )
    fun `로또구매금액 오류 `(purchaseAmountString: String) {

        val parsedAmount = purchaseAmountInputParser.parseValue(purchaseAmountString)
        assertThat(parsedAmount).isInstanceOf(ParseResult.Error::class.java)
    }
}
