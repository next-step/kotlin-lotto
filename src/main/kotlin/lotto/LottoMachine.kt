package lotto

class LottoMachine {

    fun equalsCount(bases: LottoNumber, compares: LottoNumber): Int {
        return bases.numbers.intersect(compares.numbers).count()
    }

    fun getRandoms(): List<Int> = LOTTO_NUMBERS.shuffled().subList(0, 5)

    companion object {
        val LOTTO_NUMBERS = (1..45).toList()
    }
}
