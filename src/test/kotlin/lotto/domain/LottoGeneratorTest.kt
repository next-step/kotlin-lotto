package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

class LottoGeneratorTest {

    @ParameterizedTest
    @CsvSource("5000,10000,2", "1,2,2", "1,10,10")
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급한다`(lottoPrice: Int, paidPrice: Int, expectedCount: Int) {
        val lottos = LottoGenerator(lottoPrice = Money(lottoPrice)).generate(paidPrice = Money(paidPrice))
        assertThat(lottos).hasSize(expectedCount)
    }

    @Test
    fun `모자란 구입 금액을 입력하면 에러를 일으킨다`() {
        assertThrows<IllegalArgumentException> {
            LottoGenerator(lottoPrice = Money(5000))
                .generate(paidPrice = Money(4000))
        }
    }
}
