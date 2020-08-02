package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoMakerTest {
    private lateinit var maker: LottoMaker

    @BeforeEach
    fun beforeTest() {
        maker = LottoMaker()
    }

    @DisplayName(value = "생성한 로또가 조건과 일치하는지 확인한다.")
    @Test
    fun validLottoCheck() {
        val lotto = maker.make()

        assertThat(lotto.numbers.distinct().size).isSameAs(6)
        assertThat(lotto.numbers).allSatisfy {
            assertThat(it).isGreaterThan(0)
            assertThat(it).isLessThanOrEqualTo(45)
        }
    }
}
