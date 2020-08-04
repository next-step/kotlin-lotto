package lotto

import lotto.domain.getPlace
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {
    @ParameterizedTest
    @CsvSource(
        "6,false,2000000000",
        "5,true,30000000",
        "5,false,1500000",
        "4,false,50000",
        "3,false,5000"
    )
    fun `매칭 카운트와 금액 비교 테스트`(count: Int, isBonus: Boolean, expectResult: Int) {
        val lottoResult = getPlace(count, isBonus)
        assertThat(lottoResult.price).isEqualTo(expectResult)
    }
}
