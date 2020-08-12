import lotto.LottoController
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val controller = LottoController()
    val result = controller.start(LottoInputView())
    controller.finish(LottoResultView(), result)
}
