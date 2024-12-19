package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GeneratorLottoNumbersTest {
    @Test
    fun `랜덤 번호로 티켓 1장을 생성한다`() {
        val tickets = GeneratorLottoNumbers.generateRandomLottoTickets(1)
        tickets.size shouldBe 1
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 100, 10000])
    fun `여러 로또 티켓 생성 확인`(count: Int) {
        val tickets = GeneratorLottoNumbers.generateRandomLottoTickets(count)
        tickets.size shouldBe count
    }
}
