package lotto.view.outputconverter

import lotto.domain.model.Lottos

object LottosConverter : OutputConverter<Lottos> {
    override fun convert(printable: Lottos): String {
        val lottosText = printable.value.joinToString("\n") { lotto ->
            lotto.numbers.toString()
        }

        return "${printable.getPurchaseCountText()}$lottosText"
    }

    private fun Lottos.getPurchaseCountText(): String = "${value.size}개를 구매했습니다.\n"
}
