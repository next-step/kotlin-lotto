package lotto.domain

class LottoTicket private constructor(
    val lotto: Lotto
) {

    fun isBonusNumberMatch(bonusLotto: LottoNumber): Boolean {
        return lotto.contains(bonusLotto)
    }

    fun count(lotto: Lotto): Int {
        return this.lotto.count(lotto)
    }

    companion object {
        fun create(): LottoTicket {
            val lottoInstance = Lotto.create()
            return LottoTicket(lottoInstance)
        }
    }
}
