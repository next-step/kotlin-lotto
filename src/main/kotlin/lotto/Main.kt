import lotto.domain.Customer
import lotto.strategy.ShuffleStrategy
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val inputMoney = InputView.inputMoney()
    val customer = Customer(inputMoney, ShuffleStrategy())
    ResultView.printBuyCount(customer)

    val lottos = customer.buyLotto()
    ResultView.printLottos(lottos)

    val winningNumbers = InputView.inputWinningNumber()
    val hitLottos = customer.hitLottos(winningNumbers)
    val resultList = customer.countLottos(hitLottos)

    ResultView.printResult(resultList)

    val totalRate = customer.getTotalRate()
    ResultView.printTotalRate(totalRate)
}
