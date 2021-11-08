package lotto.domain

import lotto.domain.money.Won
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

class LottoGeneratorTest {

    @ParameterizedTest
    @CsvSource("5000,10000", "1,2", "1,10")
    fun `로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급한다`(lottoPrice: Int, paidPrice: Int) {
        val lottos = LottoGenerator(lottoPrice = Won(lottoPrice)).generate(paidPrice = Won(paidPrice))
        assertThat(lottos).hasSize(paidPrice / lottoPrice)
    }

    @Test
    fun `모자란 구입 금액을 입력하면 에러를 일으킨다`() {
        assertThrows<IllegalArgumentException> {
            LottoGenerator(lottoPrice = Won(5000))
                .generate(paidPrice = Won(4000))
        }
    }
}
