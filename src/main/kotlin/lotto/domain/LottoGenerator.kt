package lotto.domain

interface LottoGenerator {

    fun generate(): Lotto

    companion object {
        val RANGE = 1..45
    }

}
