package lotto.domain

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
}
