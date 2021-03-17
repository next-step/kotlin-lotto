package lotto.domain

class LottoTicket private constructor(
    val lotto: Lotto
) {

    fun isBonusNumberMatch(bonusNumber: LottoNumber): Boolean {
        return lotto.contains(bonusNumber)
    }

    override fun toString(): String {
        return "$lotto"
    }

    companion object {
        fun create(): LottoTicket {
            val lottoInstance = Lotto.create()
            return LottoTicket(lottoInstance)
        }
    }
}
