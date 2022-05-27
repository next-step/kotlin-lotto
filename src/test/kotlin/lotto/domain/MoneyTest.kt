package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {
	@Test
	fun `머니 객체가 음수를 받았을 때 예외 발생 테스트`() {
		assertThrows<IllegalArgumentException> {
			Money(-1)
		}
	}
}
