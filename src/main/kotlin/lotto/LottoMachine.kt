package lotto

class LottoMachine {
    fun draw(): LottoNumbers {
        val result = mutableSetOf<LottoNumber>()

        while (result.size < LOTTO_NUMBER_SIZE) {
            result.add(LottoNumber())
        }
        return LottoNumbers(result.toSortedSet())
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
