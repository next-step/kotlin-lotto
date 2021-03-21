import domain.money.Money
import domain.store.LottoStore
import view.BuyingInputView
import view.BuyingResultView

fun main() {
    val store = LottoStore(price = Money(1000))

    val buyingInput = BuyingInputView().receiveAmount("구입금액을 입력해 주세요.")

    val lottos = store.buyLottos(buyingInput.toMoney())

    BuyingResultView().print(lottos)
}
