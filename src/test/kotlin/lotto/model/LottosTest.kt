package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("로또 컬렉션 테스트")
class LottosTest {

    @ParameterizedTest
    @CsvSource(
        value = ["900|0", "1000|1", "1900|1", "2000|2"],
        delimiter = '|'
    )
    fun `개당 1000원에 로또를 구입 가능`(paymentPrice: Int, lottoSize: Int) {
        // given, when
        val lottos = Lottos.from(paymentPrice).lottos

        // then
        assertEquals(lottos.size, lottoSize)
    }
}
