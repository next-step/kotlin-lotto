package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumbersTest {
    @Test
    fun `로또 숫자는 6글자여야 한다`() {
        val listOf = makeLottoNumberList(1, 2, 3, 4, 5, 6)
        LottoNumbers(listOf)
    }

    @Test
    fun `로또 숫자가 6글자가 아니면 에러가 난다`() {
        val listOf = makeLottoNumberList(1, 2, 3, 4, 5)
        assertThrows<IllegalStateException> {
            LottoNumbers(listOf)
        }
    }

    @Test
    fun `로또 당첨 숫자에 포함된 개수를 출력한다`() {
        // given
        val winningLottoNumberList = makeLottoNumberList(1, 2, 3, 4, 5, 6)
        val lottoNumberList = makeLottoNumberList(1, 2, 3, 4, 5, 6)
        val lottoNumbers = LottoNumbers(lottoNumberList)

        // when
        val contains = lottoNumbers.contains(winningLottoNumberList)

        // then
        assertTrue(contains == 6)
    }

    private fun makeLottoNumberList(vararg args: Int): List<LottoNumber> {
        val result = mutableListOf<LottoNumber>()
        for (element in args) {
            result.add(LottoNumber(element))
        }
        return result
    }
}
