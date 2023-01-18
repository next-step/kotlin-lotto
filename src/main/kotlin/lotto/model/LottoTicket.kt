package lotto.model

import lotto.service.LottoGenerator

class LottoTicket(private val value: List<String> = listOf()) {
    fun toLottos(): Lottos {
        return Lottos(value.map { LottoGenerator.fromString(it) })
    }

    fun toRandomLottos(): Lottos {
        return Lottos(value.map { LottoGenerator.getRandomLotto() })
    }

    companion object {
        private const val BLANK_SYMBOL = ""

        fun of(vararg manualNumbers: String): LottoTicket {
            return of(manualNumbers.toList())
        }

        fun of(manualNumbers: List<String>): LottoTicket {
            return LottoTicket(manualNumbers)
        }

        fun getBlankTicket(lottoCount: Int): LottoTicket {
            return LottoTicket(List(lottoCount) { BLANK_SYMBOL })
        }
    }
}
