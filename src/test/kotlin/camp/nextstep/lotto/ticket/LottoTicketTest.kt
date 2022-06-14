package camp.nextstep.lotto.ticket

import camp.nextstep.lotto.IntArrayConverter
import camp.nextstep.lotto.number.LottoNumber
import camp.nextstep.lotto.number.LottoNumber.Companion.toLottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.provider.CsvSource

internal class LottoTicketTest {

    @DisplayName("로또 티켓은 6개의 숫자를 가진다.")
    @Test
    fun sixNumbersTest() {
        val ticket = LottoTicket.of(1, 2, 3, 4, 5, 6)

        assertThat(ticket.numbers.size).isEqualTo(6)
        assertThat(ticket.numbers).hasSameElementsAs(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) })
    }

    @DisplayName("로또 티켓은 6개의 숫자를 오름차순으로 가진다.")
    @Test
    fun sortNumbersTest() {
        val ticket = LottoTicket.of(6, 4, 2, 3, 1, 5)

        val sortedNumbers = listOf(6, 4, 2, 3, 1, 5).sorted()

        for (i in 0 until LottoTicket.LOTTO_NUMBERS) {
            assertThat(ticket.numbers[i]).isEqualTo(LottoNumber.of(sortedNumbers[i]))
        }
    }

    @DisplayName("로또 티켓은 6개보다 적거나 많은 숫자를 가질 수 없다.")
    @ParameterizedTest
    @CsvSource(
        delimiter = '_',
        value = [
            "10, 20, 23, 24, 35, 10",
            "1, 1, 1, 1, 1, 1",
            "1, 1, 23, 30, 40, 40"
        ]
    )
    fun moreThanSixNumbersTest(@ConvertWith(IntArrayConverter::class) numbers: IntArray) {
        assertThrows<IllegalArgumentException> { LottoTicket.of(numbers.toList().toLottoNumbers()) }
    }

    @DisplayName("로또 티켓은 같은 숫자를 여러 개 가질 수 없다.")
    @ParameterizedTest
    @CsvSource(
        delimiter = '_',
        value = [
            "1",
            "1,2",
            "1,2,3",
            "1,2,3,4",
            "1,2,3,4,5",
            "1,2,3,4,5,6,7",
            "1,2,3,4,5,6,7,8",
        ]
    )
    fun ticketDuplicatedNumberTest(@ConvertWith(IntArrayConverter::class) numbers: IntArray) {
        assertThrows<IllegalArgumentException> { LottoTicket.of(numbers.toList().toLottoNumbers()) }
    }

    @DisplayName("로또 티켓은 1보다 작거나 45보다 큰 숫자로 이루어질 수 없다.")
    @ParameterizedTest(name = "1 <= {0} <= 45 을 만족하지 않는다.")
    @CsvSource(
        delimiter = '_',
        value = [
            "0, 1, 2, 3, 4, 5",
            "1, 2, 3, 4, 5, 100",
            "-1, 1, 2, 3, 4, 5"
        ]
    )
    fun ticketNumberRangeTest(@ConvertWith(IntArrayConverter::class) numbers: IntArray) {
        assertThrows<IllegalArgumentException> { LottoTicket.of(numbers.toList().toLottoNumbers()) }
    }
}
