package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ManualNumberGeneratorTest {
    @Test
    fun `수동으로 문자를 입력하여 로또 숫자 목록을 리턴한다`() {
        val givenText = "1,2,3,4,5,6"

        val actual = ManualNumberGenerator.generateNumbers(givenText)

        assertThat(actual).hasSize(6)
    }
}
