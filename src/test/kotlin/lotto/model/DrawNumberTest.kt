package lotto.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("추첨 번호 테스트")
class DrawNumberTest {

    @Test
    fun `당첨 번호와 보너스 번호가 중복되면 예외 발생`() {
        // given
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.valueOf(it) })
        val bonusNumber = LottoNumber.valueOf(6)

        // when, then
        val exception = assertThrows<IllegalArgumentException> { DrawNumbers(winningNumbers, bonusNumber) }
        Assertions.assertEquals("당첨 번호와 보너스 번호는 중복될 수 없습니다. (중복 번호: 6)", exception.message)
    }
}
