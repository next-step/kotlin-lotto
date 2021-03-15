package lotto.model.number

class CandidateNumber private constructor(candidateNumber: Int) : LottoNumber(candidateNumber) {
    companion object {
        private val CANDIDATE_NUMBERS = (MINIMUM..MAXIMUM).map { CandidateNumber(it) }

        fun get(candidateNumber: Int): CandidateNumber {
            validate(candidateNumber)

            return CANDIDATE_NUMBERS[candidateNumber - 1]
        }
    }
}
