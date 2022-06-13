package lotto.view.inputconverter

import lotto.domain.model.Lotto
import lotto.domain.model.UserInputResult
import lotto.domain.model.result
import lotto.isA
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoConverterTest {
    @Test
    fun `LottoConverter는 string Input을 Lotto로 변환한다`() {
        val lotto = LottoConverter.convert("1, 2, 3, 4, 5, 6")
        val expected = Lotto.from(1, 2, 3, 4, 5, 6)

        assertThat(lotto.result).isEqualTo(expected)
    }

    @Test
    fun `Int로 변환할 수 없는 값이 입력값에 포함될 경우 UserInputResult_Failed가 반환된다`() {
        assertThat(LottoConverter.convert("1, a, 2, 3, 4, 5")).isA<UserInputResult.Failed>()
    }

    @Test
    fun `6개가 아닌 값이 입력될 경우 UserInputResult_Failed가 반환된다`() {
        assertThat(LottoConverter.convert("1, 6, 2, 3, 4")).isA<UserInputResult.Failed>()
    }
}
