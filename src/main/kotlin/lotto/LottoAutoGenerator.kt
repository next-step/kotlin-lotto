package lotto

class LottoAutoGenerator : LottoGeneratorStrategy {

    override fun generate(count: Int): List<LottoNumbers> {
        return (1..count).map { generateLottoNumber() }
    }

    private fun generateLottoNumber(): LottoNumbers {
        return LottoNumbers(
            totalNumbers
                .slice(0 until 6)
                .sorted()
                .map { LottoNumber(it) }
        )
    }
}
