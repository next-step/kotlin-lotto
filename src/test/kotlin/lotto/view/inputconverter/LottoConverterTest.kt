package lotto.view.inputconverter

import lotto.domain.model.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoConverterTest {
    @Test
    fun `LottoConverter는 string Input을 Lotto로 변환한다`() {
        val lotto = LottoConverter.convert("1, 2, 3, 4, 5, 6")
        val expected = Lotto.from(1, 2, 3, 4, 5, 6)

        assertThat(lotto).isEqualTo(expected)
    }

    @Test
    fun `Int로 변환할 수 없는 값이 입력값에 포함될 경우 NumberFormatException이 발생한다`() {
        assertThrows<NumberFormatException> {
            LottoConverter.convert("1, a, 2, 3, 4, 5")
        }
    }
}
