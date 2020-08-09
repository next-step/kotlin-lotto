package lotto.model

class Lotto(val numbers: Set<LottoNumber>) {

    fun convertPrize(winnerNumbers: Lotto, bonusBall: LottoNumber): Prize {
        val matchCount = numbers.count {
            winnerNumbers.numbers.contains(it)
        }

        return Prize.findByMatchCount(matchCount = matchCount, isMatchedBonusNumber = numbers.contains(bonusBall))
    }

    companion object {
        const val PRICE = 1_000
        private const val NUMBER_COUNT = 6

        fun of(stringOfNumbers: String): Lotto {
            val lottoNumberGroup = Lotto(
                stringOfNumbers
                    .split(",")
                    .map { LottoNumber(it) }
                    .toSortedSet()
            )
            require(lottoNumberGroup.numbers.size == NUMBER_COUNT) { "유효하지 않은 로또입니다." }
            return lottoNumberGroup
        }

        fun makeAuto(): Lotto = of(LottoNumber.NUMBER_RANGE.shuffled().subList(0, NUMBER_COUNT).joinToString())
    }
}
