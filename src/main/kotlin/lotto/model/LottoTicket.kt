package lotto.model

import lotto.model.number.CandidateNumbers
import lotto.model.number.CandidateNumbers.Companion.autoCreate
import lotto.model.number.LottoNumber
import lotto.model.number.LottoNumbers

class LottoTicket(val candidateNumbers: CandidateNumbers = autoCreate()) {
    constructor(candidateNumbers: List<Int>) : this(CandidateNumbers(candidateNumbers))

    fun countMatch(targetNumber: LottoNumber): Int {
        return if (candidateNumbers.contains(targetNumber)) 1 else 0
    }

    fun countMatch(targetNumbers: LottoNumbers): Int {
        return candidateNumbers.filter {
            targetNumbers.contains(it)
        }.count()
    }

    override fun toString(): String {
        return candidateNumbers.toString()
    }

    companion object {
        val PRICE = Money.THOUSAND
    }
}
