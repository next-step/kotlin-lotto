package lotto.domain

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoGameTest {

    private lateinit var lottoGame: LottoGame
    private lateinit var manualNumbers: List<List<String>>

    @BeforeEach
    fun init() {
        lottoGame = LottoGame(Money(4000))
        manualNumbers = listOf(
            listOf("3", "5", "6", "7", "8", "13"),
            listOf("3", "5", "6", "7", "8", "11"),
            listOf("3", "5", "6", "7", "8", "9"),
            listOf("5", "21", "31", "44", "25", "10")
        )
    }

    @Test
    fun `가진 금액에 비해서 사려는 수동 로또가 많을 때 Exception 발생 확인`() {
        assertThrows<IllegalStateException> { lottoGame.purchaseManualLottoes(5, manualNumbers) }
    }
}
