package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FixedLottoFactoryTest {
    @Test
    fun `주어진 당첨 번호들로부터 로또 리스트를 생성한다`() {
        // given
        val fixedNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 22, 33, 4, 5, 6),
            listOf(1, 22, 33, 44, 5, 6),
            listOf(11, 2, 3, 4, 5, 6)
        )
        val fixedLottoFactory = FixedLottoFactory(
            numbers = fixedNumbers
        )

        // when
        val lottoList = fixedLottoFactory.create(fixedNumbers.size)

        // then
        assertEquals(4, lottoList.size)
        assertEquals(listOf(1, 2, 3, 4, 5, 6).map { it.toLottoNumber() }, lottoList[0].lottoNumbers)
    }

    @Test
    fun `수동으로 구매할 로또 개수와 입력한 로또의 개수가 일치하지 않을때 IllegalArgumentException을 발생시킨다`() {
        // given
        val fixedLottoSize = 5
        val fixedLottoNumbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 22, 33, 4, 5, 6),
            listOf(1, 22, 33, 44, 5, 6),
            listOf(11, 2, 3, 4, 5, 6)
        )

        assertThrows<IllegalArgumentException> { // then
            FixedLottoFactory(
                numbers = fixedLottoNumbers
            ).create(fixedLottoSize) // when
        }
    }
}
