package lotto.domain

class RandomLottoLineGenerator : LottoLineGenerator {
    override fun generate(): LottoLine {
        val numbers =
            (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE)
                .shuffled()
                .take(LottoLine.LINE_SIZE)
        return LottoLine.from(numbers)
    }
}
