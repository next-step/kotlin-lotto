package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoGameTest {
    
    @Test
    fun `1등은 6개 일치` () {
        val lottoGame = LottoGame()
        val userLotto = setOf(1, 2, 3, 4, 5, 6)
        val winningLotto = setOf(1, 2, 3, 4, 5, 6)
        val actual = lottoGame.match(userLotto, winningLotto)
        
        actual shouldBe 1
    }
    
    @Test
    fun `2등은 5개 일치`() {
        val lottoGame = LottoGame()
        val userLotto = setOf(1, 2, 3, 4, 5, 6)
        val winningLotto = setOf(1, 2, 3, 4, 5, 7)
        val actual = lottoGame.match(userLotto, winningLotto)

        actual shouldBe 2
    }
    
    @Test
    fun `3등은 4개 일치`() {
        val lottoGame = LottoGame()
        val userLotto = setOf(1, 2, 3, 4, 5, 6)
        val winningLotto = setOf(1, 2, 3, 4, 7, 8)
        val actual = lottoGame.match(userLotto, winningLotto)
        
        actual shouldBe 3
    }
    
    @Test
    fun `4등은 3개 일치`() {
        val lottoGame = LottoGame()
        val userLotto = setOf(1, 2, 3, 4, 5, 6)
        val winningLotto = setOf(1, 2, 3, 7, 8, 9)
        val actual = lottoGame.match(userLotto, winningLotto)

        actual shouldBe 4
    }
    
    @Test
    fun `2개 경우 일치 하면 0`(userLotto: Set<Int>) {
        val lottoGame = LottoGame()
        val userLotto = setOf(1, 2, 12, 13, 14, 15)
        val winningLotto = setOf(1, 2, 3, 7, 8, 9)
        val actual = lottoGame.match(userLotto, winningLotto)

        actual shouldBe 4
    }

    @Test
    fun `1개 경우 일치 하면 0`(userLotto: Set<Int>) {
        val lottoGame = LottoGame()
        val userLotto = setOf(1, 11, 12, 13, 14, 16)
        val winningLotto = setOf(1, 2, 3, 7, 8, 9)
        val actual = lottoGame.match(userLotto, winningLotto)

        actual shouldBe 4
    }

    @Test
    fun `0개 경우 일치 하면 0`(userLotto: Set<Int>) {
        val lottoGame = LottoGame()
        val userLotto = setOf(10, 11, 12, 13, 14, 16)
        val winningLotto = setOf(1, 2, 3, 7, 8, 9)
        val actual = lottoGame.match(userLotto, winningLotto)

        actual shouldBe 4
    }
}
