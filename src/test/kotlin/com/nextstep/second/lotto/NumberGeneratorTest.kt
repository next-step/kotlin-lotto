package com.nextstep.second.lotto

import com.nextstep.second.lotto.domain.Lotto
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class NumberGeneratorTest {
    @Test
    fun `자동으로 6자리 숫자를 생성한다`() {
        // given
        val numbers = NumberGenerator.generate()

        // then
        numbers.size shouldBe Lotto.LOTTO_LENGTH
        numbers.all { it in 1..45 } shouldBe true
    }
}
