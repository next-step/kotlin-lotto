package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoCollectionTests {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `여러개의 로또를 구매가 가능하다`(count: Int) {
        val lottoCollection: LottoCollection = LottoCollection(count)

        assertThat(lottoCollection.lotto.size)
            .isEqualTo(count)
    }
    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `로또는 1개이상 구매가 가능하다`(count: Int) {
        assertThrows<IllegalArgumentException> { LottoCollection(count) }
    }
}
