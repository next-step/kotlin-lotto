package lottoTest

import lotto.domain.LottoStatResult
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStatResultTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "0,0,0,0,0,20000,0",
            "1,1,1,1,1,27000,75242.78",
            "0,0,0,0,2,12000,0.83"
        ]
    )
    fun `수익률 계산`(
        firstCount: Int,
        secondCount: Int,
        thirdCount: Int,
        fourthCount: Int,
        fifthCount: Int,
        purchaseAmount: Int,
        expected: Double,
    ) {
        val lottoStatResult =
            LottoStatResult(
                firstCount,
                secondCount,
                thirdCount,
                fourthCount,
                fifthCount,
                purchaseAmount,
            )

        assertEquals(expected, lottoStatResult.getReturnRate())
    }
}
