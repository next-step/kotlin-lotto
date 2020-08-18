package model

class LottosGeneratorAuto() : LottosGenerator {
    override fun generate(money: Money): List<Lotto> {
        val list = mutableListOf<Lotto>()
        repeat(money.getLottoCount()) { list.add(Lotto.make()) }
        return list.toList()
    }

    override fun lottoManualCount(): Int {
        return 0
    }

    override fun lottoAutoCount(money: Money): Int {
        return money.getAutoCreateCount(LottoManual(0))
    }
}
