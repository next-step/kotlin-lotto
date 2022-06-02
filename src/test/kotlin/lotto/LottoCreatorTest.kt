package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoCreatorTest {

    @ParameterizedTest
    @ValueSource(ints = [5, 6, 7, 10])
    fun `요청 갯수 만큼 로또티켓을 생성한다`(requestCount: Int) {
        val autoCreate = LottoCreator.autoCreate(requestCount)
        assertThat(autoCreate.size).isEqualTo(requestCount)
    }
}
