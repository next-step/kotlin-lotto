package lottoTest

import lotto.LottoStatResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStatResultTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "0,0,0,0,20000,0",
            "1,1,1,1,27000,74131.67",
            "0,0,0,2,12000, 0.83"
        ]
    )
    fun `수익률 계산`(
        firstCount: Int,
        thirdCount: Int,
        fourthCount: Int,
        fifthCount: Int,
        purchaseAmount: Int,
        expected: Double,
    ) {
        val lottoStatResult = LottoStatResult(firstCount, thirdCount, fourthCount, fifthCount, purchaseAmount)

        assertEquals(expected, lottoStatResult.getReturnRate())
    }
}
