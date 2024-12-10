package lotto.domain

import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import lotto.controller.GeneratorRandomNumbers
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @Test
    fun `로또 티켓을 한장 생성한다`() {
        val ticket = LottoTicket(1, 2, 3, 4, 5, 6)
        ticket.equals(listOf(1, 2, 3, 4, 5, 6)).shouldBeTrue()
    }

    @Test
    fun `랜덤하게 로또 번호를 한개 생성한다`() {
        val ticket = GeneratorRandomNumbers.generateLottoTicker()
        println(ticket)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4])
    fun `int 를 비교한다`(value: Int) {
        val lottoNumber = LottoNumber(value)
        lottoNumber.equals(value) shouldBe true
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4])
    fun `객체를 비교한다`(value: Int) {
        val lottoNumber = LottoNumber(value)
        (lottoNumber == LottoNumber(value)) shouldBe true
    }
}
