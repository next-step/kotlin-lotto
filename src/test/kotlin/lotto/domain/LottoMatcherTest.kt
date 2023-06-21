package lotto.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoMatcherTest {

    private lateinit var lottoMatcher: LottoMatcher

    @BeforeEach
    fun setUp() {
        lottoMatcher = LottoMatcher()
    }

    @Test
    fun `로또 번호와 당첨 번호를 가지고 당첨 통계를 낸다`() {
//        lottoMatcher.count()
    }
}
