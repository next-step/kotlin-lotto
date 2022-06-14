package lotto.view.outputconverter

import lotto.domain.model.Lottos

object LottosConverter : OutputConverter<Lottos> {
    override fun convert(printable: Lottos): String {
        return printable.value.joinToString("\n") { lotto ->
            lotto.numbers.toString()
        }
    }
}
