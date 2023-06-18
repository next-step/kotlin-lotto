package com.nextstep.second.lotto

import com.nextstep.second.lotto.domain.Lotto
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTest {
    @Test
    fun `로또 번호를 생성한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val lotto = Lotto.of(numbers)

        // then
        lotto.numbers.size shouldBe Lotto.LOTTO_LENGTH
    }

    @Test
    fun `로또 숫자가 6개가 아니라면 생성에 오류가 발생한다`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5)

        // when
        assertThrows<IllegalArgumentException> {
            Lotto.of(numbers)
        }
    }
}
