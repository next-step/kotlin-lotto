package lotto

class LottoShop {
    fun buy(count: Int): List<Set<Int>> {
        val lottoGenerator = LottoGenerator()
        val lottos = mutableListOf<Set<Int>>()
        repeat(count) {
            lottos.add(lottoGenerator.generate())
        }
        
        return lottos
    }
}
