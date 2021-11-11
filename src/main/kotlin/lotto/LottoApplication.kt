package lotto

fun main() {
    LottoApplication(SimpleLottoService(), SimpleLottoView).run()
}

class LottoApplication(
    private val lottoService: LottoService,
    private val lottoView: LottoView,
) {
    fun run() {

    }
}
