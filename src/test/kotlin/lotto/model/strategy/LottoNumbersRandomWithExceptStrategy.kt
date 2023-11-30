package lotto.model.strategy

// class LottoNumbersRandomWithExceptStrategy(
//    private val exceptValues: Set<Int>
// ) : LottoNumbersStrategy {
//
//    private val random = Random(System.currentTimeMillis())
//
//    override fun pick(): Set<Int> {
//        return generateSequence { random.nextInt(LottoNumber.LOWER_LIMIT_VALUE, LottoNumber.UPPER_LIMIT_VALUE) }
//            .filterNot { it in exceptValues }
//            .first()
//    }
// }
