package model

class LottosGeneratorManual(private val manual: LottoManual, private val lottoListManual: List<Lotto>) : LottosGenerator {
    override fun generate(money: Money): List<Lotto> {
        val list = mutableListOf<Lotto>()
        list.addAll(lottoListManual)
        repeat(money.getAutoCreateCount(manual)) { list.add(Lotto.make()) }
        return list.toList()
    }

    override fun lottoManualCount(): Int {
        return manual.value
    }

    override fun lottoAutoCount(money: Money): Int {
        return money.getAutoCreateCount(manual)
    }
}
