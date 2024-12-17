package lotto.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GeneratorLottoNumbersTest {
    @Test
    fun `로또 번호 생성기 생성`() {
        assertDoesNotThrow {
            GeneratorLottoNumbers()
        }
    }

    @Test
    fun `로또 번호 생성기 생성-실패(음수)`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            GeneratorLottoNumbers(-1..10)
        }
    }

    @Test
    fun `로또 번호 생성기 생성-실패(갯수)`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            GeneratorLottoNumbers(1..2)
        }
    }

    @Test
    fun `1~6을 넣었을때 1,2,3,4,5,6 번호를 가진 티켓이 나와야 한다`() {
        val tickets = GeneratorLottoNumbers(1..6).generateRandomLottoTickets(1)
        tickets.getOrNull(0)?.correctNumberCount(
            LottoTicket(
                (1..6).map {
                    LottoNumber(it)
                },
            ),
        ) shouldBe 6
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 100, 10000])
    fun `여러 로또 티켓 생성 확인`(count: Int) {
        val tickets = GeneratorLottoNumbers().generateRandomLottoTickets(count)
        tickets.size shouldBe count
    }
}
