package lotto.model.number

import java.util.TreeSet

class CandidateNumbers(candidateNumbers: TreeSet<CandidateNumber>) : LottoNumbers(candidateNumbers) {
    init {
        require(candidateNumbers.size == CANDIDATE_SIZE) { "로또 후보 숫자들은 6개의 로또 숫자로 이루어져 있습니다!" }
    }

    constructor(candidateNumbers: List<Int>) : this(TreeSet(candidateNumbers.map { CandidateNumber.get(it) }))

    companion object {
        private const val CANDIDATE_SIZE = 6

        fun autoCreate(): CandidateNumbers {
            return CandidateNumbers(
                List(LottoNumber.MAXIMUM) { i -> i + 1 }.shuffled().subList(0, CANDIDATE_SIZE)
            )
        }
    }
}
