package lotto.domain.model

@JvmInline
value class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "$MESSAGE_INVALID_LOTTO_NUMBERS_SIZE${numbers.size}"
        }
    }

    fun intersectCount(other: Lotto): Int = (numbers intersect other.numbers).count()

    fun checkWith(winningNumbers: WinningNumbers): LottoRank {
        val (matchedNumbers, notMatchedNumbers) = matchNumberGroup(winningNumbers.numbers)

        val numberOfMatches = NumberOfMatches(matchedNumbers.size)
        val isBonusBallMatched = winningNumbers.bonusBall in notMatchedNumbers

        return LottoRank.of(numberOfMatches, isBonusBallMatched)
    }

    private fun matchNumberGroup(winningNumbers: Set<LottoNumber>): Pair<List<LottoNumber>, List<LottoNumber>> {
        fun Map<Boolean, List<LottoNumber>>.getNumbers(isMatched: Boolean): List<LottoNumber> {
            return get(isMatched) ?: listOf()
        }

        val matchNumberGroup = numbers.groupBy { lottoNumber ->
            lottoNumber in winningNumbers
        }

        return matchNumberGroup.getNumbers(true) to matchNumberGroup.getNumbers(false)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        private const val MESSAGE_INVALID_LOTTO_NUMBERS_SIZE = "로또 번호는 6개의 숫자로 이루어져야 합니다.\n입력된 숫자 수 : "

        fun from(numbers: List<Int>): Lotto {
            return Lotto(
                numbers.map { number ->
                    LottoNumber[number]
                }.toSet()
            )
        }

        fun default(): Lotto {
            return Lotto(
                setOf(
                    LottoNumber[1],
                    LottoNumber[2],
                    LottoNumber[3],
                    LottoNumber[4],
                    LottoNumber[5],
                    LottoNumber[6]
                )
            )
        }
    }
}
