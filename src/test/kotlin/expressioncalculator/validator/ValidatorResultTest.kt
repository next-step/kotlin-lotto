package expressioncalculator.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidatorResultTest {
    @Test
    fun `ValidatorResult는 Validator를 통한 유효성 검사의 성공실패 여부를 표시한다`() {
        assertThat(ValidateResult.Success).isNotEqualTo(ValidateResult.Failed)
        assertThat(ValidateResult.Success).isEqualTo(ValidateResult.Success) // XXX : 이런 당연해 보이는 테스트가 필요가 있을까?
        assertThat(ValidateResult.Failed).isEqualTo(ValidateResult.Failed)
    }
}
