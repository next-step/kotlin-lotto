package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("자동 로또 생성 테스트")
class RandomLottoGeneratingTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `로또 생성 개수에 맞게 자동 로또를 정상 생성`(lottoSize: Int) {
        // given
        val randomLottos = RandomLottoGenerating.generateLottos(lottoSize)

        // when, then
        assertEquals(randomLottos.count, lottoSize)
    }
}
