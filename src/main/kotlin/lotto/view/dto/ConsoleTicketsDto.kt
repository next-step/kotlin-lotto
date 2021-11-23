package lotto.view.dto

import lotto.domain.Lottos

data class ConsoleTicketsDto(
    val count: Int,
    val lottos: String,
) {
    constructor(lottos: Lottos) : this(
        lottos.count(),
        lottos.toList().joinToString(
            separator = System.lineSeparator()
        ) {
            it.toList().joinToString(
                prefix = TICKET_PREFIX,
                postfix = TICKET_POSTFIX,
            ) { number -> number.value.toString() }

        }
    )

    companion object {
        private const val TICKET_PREFIX = "["
        private const val TICKET_POSTFIX = "]"
    }
}
