import lotto.LottoController
import lotto.domain.LottoAnalytics
import lotto.view.LottoResultView
import lotto.view.LottoStartView

fun main() {
    val controller = LottoController()
    val result = controller.start(LottoStartView(), LottoAnalytics())
    controller.finish(LottoResultView(), result)
}
