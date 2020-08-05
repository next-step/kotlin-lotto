package lotto.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {
    private lateinit var lottos: Lottos

    @BeforeEach
    fun `set up`() {
        lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
                Lotto(listOf(13, 14, 15, 16, 17, 18))
            )
        )
    }

    @DisplayName("toString()을 하면, 모든 로또의 번호를 반환한다")
    @Test
    fun `print toString()`() {
        print(lottos.toString())
    }
}
