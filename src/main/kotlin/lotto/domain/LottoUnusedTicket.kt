package lotto.domain

class LottoUnusedTicket {

    fun toAuto(): LottoUsedTicket {
        return LottoUsedTicket(
            LottoNumbers.from()
        )
    }
}
