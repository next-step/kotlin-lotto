package lotto

import lotto.domain.getPlace
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {
    @ParameterizedTest
    @CsvSource(
        "6,2000000000",
        "5,1500000",
        "4,50000",
        "3,5000"
    )
    fun `매칭 카운트와 금액 비교 테스트`(count: Int, expectResult: Int) {
        val lottoResult = getPlace(count)
        assertThat(lottoResult.price).isEqualTo(expectResult)
    }
}
