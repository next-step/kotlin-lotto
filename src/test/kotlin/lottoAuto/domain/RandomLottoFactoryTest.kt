package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RandomLottoFactoryTest {
    @ParameterizedTest
    @CsvSource(
        "0",
        "1",
        "14"
    )
    fun `구매 금액이 주어질 경우 임의의 당첨번호로 구성된 로또 리스트를 생성한다`(lottoSize: Int) {
        // given
        val randomLottoFactory = RandomLottoFactory()

        // when
        val lottoList = randomLottoFactory.create(lottoSize)

        // then
        assertEquals(lottoSize, lottoList.size)
    }
}
