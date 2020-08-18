package model

interface LottosGenerator {
    fun generate(money: Money): List<Lotto>
    fun lottoManualCount(): Int
    fun lottoAutoCount(money: Money): Int
}
