import domain.PurchasedLotto
import domain.WinningLotto
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `calculateWinningLottoTest`(){
        val target = listOf<Int>(1,2,3,4,5,6)
        val winning = listOf<Int>(1,6,7,8,9,10)
        val winningLotto = WinningLotto(numbers = winning)
        val purchasedLotto = PurchasedLotto(numbers = target)
        val winningCount = purchasedLotto.calculateWinningCount(winningLotto)
        println(winningCount)
    }
}