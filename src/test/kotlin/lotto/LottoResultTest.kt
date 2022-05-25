package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoResultTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "1,2,3,4,5,6 : 7,8,9,10,11,12 : 0 : 0",
            "1,2,3,4,5,6 : 1,2,3,7,8,9 : 3 : 5000",
            "1,2,3,4,5,6 : 1,2,3,7,8,9 : 3 : 5000",
            "1,2,3,4,5,6 : 1,2,3,4,8,9 : 4 : 50000",
            "1,2,3,4,5,6 : 1,2,3,4,5,9 : 5 : 1500000",
            "1,2,3,4,5,6 : 1,2,3,4,5,6 : 6 : 2000000000",
        ],
        delimiter = ':'
    )
    fun `전달 받은 당첨 번호의 수와 당첨 금액 확인`(winningValue: String, lottoValue: String, machCount: Int, prize: Int) {
        val lottoResult = LottoResult(winningValue, Lotto(numbers = lottoValue.split(",").map { it.toInt() }.toList()))

        assertThat(lottoResult.machCount).isEqualTo(machCount)
        assertThat(lottoResult.prize).isEqualTo(prize)
    }

}
