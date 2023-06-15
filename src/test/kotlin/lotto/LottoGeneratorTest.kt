package lotto

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoGeneratorTest {

    private lateinit var lottoGenerator: LottoGenerator

    @BeforeEach
    fun setup() {
        lottoGenerator = LottoGenerator()
    }

    @ParameterizedTest
    @CsvSource(
        "100",
        "1001",
        "5050",
        "10101",
    )
    fun `로또 생성기는 로또 구입 금액이 1000원 미만 또는 1000원 단위가 아닐 경우 IllegalArgumentException 을 발생`(purchaseAmount: Int) {
        shouldThrow<IllegalArgumentException> {
            lottoGenerator.generate(purchaseAmount)
        }
    }
}
