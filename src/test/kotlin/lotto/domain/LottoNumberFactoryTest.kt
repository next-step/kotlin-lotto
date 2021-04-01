package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoNumberFactoryTest {
    @DisplayName("구분자를 기준으로 숫자를 입력받아 LottoNumber 리스트 반환")
    @Test
    fun create() {
        val input = "1,2,3,4,5,6"

        val actual = LottoNumberFactory.create(input)

        assertThat(actual).isEqualTo(createLottoNumbers(1, 2, 3, 4, 5, 6))
    }
}
