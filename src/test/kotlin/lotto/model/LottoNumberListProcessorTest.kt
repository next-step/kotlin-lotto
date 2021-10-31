package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumberListProcessorTest {
    @Test
    @DisplayName("로또 생성 개수 확인")
    fun `check lotto count`() {
        // given
        val price = Price(3000)

        // when
        val lottoList = LottoNumberListProcessor(price).generateLottoList()

        // then
        assertThat(lottoList.size).isEqualTo(3)
    }
}
