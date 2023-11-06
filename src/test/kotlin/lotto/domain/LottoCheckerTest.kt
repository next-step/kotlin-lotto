package lotto.domain

import io.kotest.matchers.maps.shouldContainKey
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoCheckerTest {
    private lateinit var lottoChecker: LottoChecker

    @BeforeEach
    fun setUp() {
        lottoChecker = LottoChecker()
    }

    @Test
    fun `당첨 번호가 주어졌을 때, 로또가 몇 개 일치하는 지 알 수 있다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winNum = lottoChecker.getWinNum(lotto, listOf(1, 2, 3, 9, 10, 11))
        winNum shouldBe 3
    }

    @Test
    fun `로또가 여러 개 존재할 때, 당첨번호가 주어졌을 때 통계를 리턴할 수 있습니다`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lotto1 = Lotto(listOf(1, 2, 3, 11, 12, 13))
        val lotto2 = Lotto(listOf(1, 2, 14, 15, 16, 17))

        val lottos = Lottos(listOf(lotto, lotto1, lotto2))

        val winNumStatistics = lottoChecker.getWinNumStatistics(lottos, listOf(1, 2, 3, 4, 44, 45))
        winNumStatistics.get(4) shouldBe 1
    }
}
