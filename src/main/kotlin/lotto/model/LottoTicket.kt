package lotto.model

import lotto.model.number.CandidateNumbers
import lotto.model.number.LottoNumber
import lotto.model.number.LottoNumbers

class LottoTicket(val candidateNumbers: CandidateNumbers) {
    constructor(candidateNumbers: List<Int>) : this(CandidateNumbers(candidateNumbers))

    constructor(generator: NumbersGenerator = RandomNumbersGenerator()) : this(
        CandidateNumbers(
            generator.getNumbers(
                LottoNumber.MAXIMUM,
                CandidateNumbers.CANDIDATE_SIZE
            )
        )
    )

    fun isMatch(targetNumber: LottoNumber): Boolean {
        return candidateNumbers.contains(targetNumber)
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
