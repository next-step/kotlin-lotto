package lotto.domain

class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개가 있어야 합니다" }
    }

    constructor(generator: LottoNumberGenerator = LottoNumberRandomGenerator()) : this(
        createLottoNumberByGenerator(
            generator
        )
    )

    fun matchByWonNumber(wonNumbers: LottoWonNumbers): Rank {
        val wonNumberCount: Int = numbers.count { wonNumbers.lottoNumber.contains(it) }
        val matchBonus: Boolean = numbers.contains(wonNumbers.bonusNUmber)

        return Rank.getRankByCount(wonNumberCount, matchBonus)
    }

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]")
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        private fun createLottoNumberByGenerator(generator: LottoNumberGenerator): Set<LottoNumber> {
            val lottoNumbers = mutableSetOf<LottoNumber>()

            while (lottoNumbers.size < LOTTO_NUMBER_COUNT) {
                lottoNumbers.add(LottoNumber(generator.pickNumber()))
            }

            return lottoNumbers.toSet()
        }
    }
}
