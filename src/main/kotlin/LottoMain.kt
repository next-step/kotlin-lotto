import lotto.LottoController
import lotto.domain.LottoAnalytics
import lotto.view.LottoResultView
import lotto.view.LottoInputView

fun main() {
    val controller = LottoController()
    val result = controller.start(LottoInputView(), LottoAnalytics())
    controller.finish(LottoResultView(), result)
}
