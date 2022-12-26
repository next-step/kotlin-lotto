package lotto.domain

class LottoUnusedTicket {

    fun toAuto(): LottoUsedTicket {
        return LottoUsedTicket(
            LottoNumbers.from()
        )
    }

    fun toManual(input: String): LottoUsedTicket {
        return LottoUsedTicket(
            LottoNumbers.from(input)
        )
    }
}
