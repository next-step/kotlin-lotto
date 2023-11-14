package me.parker.nextstep.kotlinlotto.domain

class LottoTicket(val lottoNumbers: LottoNumbers) {

    fun match(winningLottoTicket: LottoTicket, bonusLottoNumber: LottoNumber): LottoRank {
        val matchCount = lottoNumbers.values.intersect(winningLottoTicket.lottoNumbers.values.toSet()).size
        val matchedBonus = lottoNumbers.values.contains(bonusLottoNumber)

        return LottoRank.of(matchCount, matchedBonus)
    }

    override fun toString(): String {
        return "LottoTicket(lottoNumbers=$lottoNumbers)"
    }

    companion object {
        const val PRICE: Int = 1_000

        fun automatic(): LottoTicket {
            return LottoTicket(LottoNumbers(RandomLottoNumbersGenerationRule()))
        }

        fun manual(numbers: List<Int>): LottoTicket {
            return LottoTicket(LottoNumbers(ManualLottoNumbersGenerationRule(numbers)))
        }
    }
}
