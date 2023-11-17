package study.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {
    @Test
    fun `LottoNumbers 생성 시 유효한 로또 번호 리스트일 경우 정상적으로 생성해야 한다`() {
        val numbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val lottoNumbers = LottoNumbers(numbers)

        assertEquals(numbers, lottoNumbers)
    }

    @Test
    fun `LottoNumbers 생성 시 로또 번호 리스트가 비어있으면 예외를 던져야 한다`() {
        val emptyNumbers = emptySet<LottoNumber>()

        val exception = assertThrows(IllegalArgumentException::class.java) {
            LottoNumbers(emptyNumbers)
        }
        assertEquals("LottoNumbers cannot be empty", exception.message)
    }

    @Test
    fun `LottoNumbers 생성 시 로또 번호 리스트의 크기가 정확히 6이 아니면 예외를 던져야 한다`() {
        val invalidNumbers = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5)
        )

        val exception = assertThrows(IllegalArgumentException::class.java) {
            LottoNumbers(invalidNumbers)
        }
        assertEquals(
            "LottoNumbers size must be equal to ${LottoNumbers.NUMBERS_COUNT}",
            exception.message
        )
    }

    @Test
    fun `random 메서드는 6개의 고유한 번호로 이루어진 LottoNumbers를 생성한다`() {
        val lottoNumbers = LottoNumbers.random()

        assertEquals(6, lottoNumbers.size)
        assertTrue(lottoNumbers.distinct().size == 6)
        assertTrue(lottoNumbers.all { it.number in 1..45 })
    }

    @Test
    fun `get 메서드는 정수 리스트에서 LottoNumbers를 생성한다`() {
        val intList = listOf(1, 7, 12, 23, 30, 42)
        val lottoNumbers = LottoNumbers.get(intList)
        assertEquals(6, lottoNumbers.size)
        assertTrue(lottoNumbers.map { it.number } == intList)
    }

    @Test
    fun `get 메서드는 정수 Array 에서 LottoNumbers를 생성한다`() {
        val expected = arrayOf(1, 7, 12, 23, 30, 42)
        val lottoNumbers = LottoNumbers.get(1, 7, 12, 23, 30, 42)
        assertEquals(6, lottoNumbers.size)
        assertTrue(lottoNumbers.map { it.number } == expected.toList())
    }

    @Test
    fun `get 메서드는 리스트 크기가 6이 아닌 경우 예외를 던진다`() {
        val invalidIntList = listOf(1, 7, 12, 23, 30)
        assertThrows<IllegalArgumentException> {
            LottoNumbers.get(invalidIntList)
        }
    }

    @Test
    fun `get 메서드는 중복된 숫자가 있는 경우 예외를 던진다`() {
        val duplicateIntList = listOf(1, 7, 12, 23, 30, 7)
        assertThrows<IllegalArgumentException> {
            LottoNumbers.get(duplicateIntList)
        }
    }
}
