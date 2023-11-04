package lotto.domain

class Lotto (
    private val money: Int
) {
    val lines: List<List<Int>>

    init {
        val generateLines = mutableListOf<List<Int>>()
        repeat(getQuantity()) {
            generateLines.add(LottoNumber.generate())
        }
        lines = generateLines
    }

    private fun getQuantity(): Int = money / LOTTO_FEE

    companion object {
        const val LOTTO_FEE: Int = 1_000
    }
}
