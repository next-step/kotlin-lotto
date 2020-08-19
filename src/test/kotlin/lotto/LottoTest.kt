package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {
    val winningNumber = listOf(1, 2, 3, 14, 15, 16)
    val userNumber = listOf(1, 2, 3, 4, 5, 6)

    @Test
    @DisplayName("test input money")
    fun inputTest() {
        assertThat(InputNumber.buy()).isEqualTo(14)
    }

    @Test
    fun `generateTest`(){
        assertThat(Lotto().generateTest(setOf(1,2,3,4,5,6))).isEqualTo(true)
    }

    @Test
    @DisplayName("Ticket")
    fun ticketsTest() {
        assertThat(Lottos(14)).isEqualTo(14)
    }

    @Test
    @DisplayName("Check to change Prize")
    fun prize() {
        assertThat(Rank.findMatchCount(5)).isEqualTo(Rank)
    }

    @Test
    fun `rewardCheck`(){
        assertThat(Lotto().getPrizeTest(userNumber,winningNumber)).isEqualTo(Rank.THREE_MATCH)
    }
/*
    @Test
    @DisplayName("당첨 확인")
    private var  ticket =  Ticket()
    fun fiveThousandDollar(){
        assertThat()
    }
*/
}
