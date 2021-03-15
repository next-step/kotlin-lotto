package lotto.model

import lotto.model.number.CandidateNumber
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CandidateNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 50])
    fun `로또 번호는 1에서 45 사이의 자연수이다`(number: Int) {
        assertThrows<IllegalArgumentException> {
            CandidateNumber.get(number)
        }
    }
}
