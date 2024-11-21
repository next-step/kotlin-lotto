package lotto

class Generator {
    fun generate(lottoCount: Int): Lottos =
        Lottos((1..lottoCount).map { Lotto() })
}
